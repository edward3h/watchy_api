package watchy_api.controllers;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.server.netty.converters.HttpDataToStringConverter;
import io.micronaut.http.server.util.HttpClientAddressResolver;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import watchy_api.models.TemperatureUnit;
import watchy_api.models.WatchyInfo;
import watchy_api.services.IpLocationService;
import watchy_api.services.WeatherService;

/**
 *
 * @author edward
 */
@Controller("/watchy")
public class WatchyController {
    private final IpLocationService ipLocationService;
    private final WeatherService weatherService;
    private final HttpClientAddressResolver resolver;

    public WatchyController(IpLocationService ipLocationService, WeatherService weatherService, HttpClientAddressResolver resolver) {
        this.ipLocationService = ipLocationService;
        this.weatherService = weatherService;
        this.resolver = resolver;
    }


    @Get("/{temperatureUnit}")
    public WatchyInfo getWatchyInfo(@PathVariable TemperatureUnit temperatureUnit, HttpRequest request) throws UnknownHostException {
        var ipAddress = InetAddress.getByName(resolver.resolve(request));
        if (request.getParameters().contains("x-ip")) {
            ipAddress = InetAddress.getByName(request.getParameters().get("x-ip"));
        }
        var location = ipLocationService.getLocationInfo(ipAddress);
        var weather = weatherService.getWeather(temperatureUnit, location.getLatitude(), location.getLongitude());
        var localTime = LocalDateTime.now(ZoneId.of(location.getTimezone()));
        return new WatchyInfo(localTime.toEpochSecond(ZoneOffset.UTC), 
        temperatureUnit, 
        weather.getCurrentTemperature(), 
        weather.getLowTemperature(), 
        weather.getHighTemperature(), 
        weather.getWeatherConditionCode());
    }
}
