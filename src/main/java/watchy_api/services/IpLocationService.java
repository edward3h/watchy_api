package watchy_api.services;
import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import io.micronaut.scheduling.TaskScheduler;
import java.net.InetAddress;
import java.time.Duration;
import jakarta.inject.Singleton;
import watchy_api.models.LocationInfo;

/**
 * 
 * @author edward
 */
 @Singleton
 @CacheConfig("location-info")
public class IpLocationService {
    private final IpApiClient client;
    private final TaskScheduler scheduler;

// TODO whole buncha race conditions here, should probably serialize requests
    private volatile boolean blocked = false;

    public IpLocationService(IpApiClient client, TaskScheduler scheduler) {
        this.client = client;
        this.scheduler = scheduler;
    }

    @Cacheable
    public LocationInfo getLocationInfo(InetAddress ip) {
        if (blocked) {
            throw new HttpStatusException(HttpStatus.SERVICE_UNAVAILABLE, "outgoing rate limit exceeded");
        }
        var response = client.get(ip.getHostAddress());
        var rl = response.getHeaders().getInt("X-Rl");
        var ttl = response.getHeaders().getInt("X-Ttl");
        if (rl <= 0) {
            _block(ttl);
        }
        return _convert(response.body());
    }

    private void _block(Integer ttl) {
        blocked = true;
        scheduler.schedule(Duration.ofSeconds(ttl), this::_unblock);
    }

    private void _unblock() {
        blocked = false;
    }

    private LocationInfo _convert(IpApiResult ipApiResult) {
        if ("fail".equals(ipApiResult.getStatus())) {
            // TODO
        }
        var result = new LocationInfo(
            ipApiResult.getTimezone(),
            ipApiResult.getLat(),
            ipApiResult.getLon()
        );
        return result;
    }
}

