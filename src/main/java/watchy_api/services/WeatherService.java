package watchy_api.services;

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.context.annotation.Property;
import javax.inject.Singleton;
import watchy_api.models.TemperatureUnit;
import watchy_api.models.WeatherInfo;

/**
 *
 * @author edward
 */
 @Singleton
 @CacheConfig("weather")
public class WeatherService {
    private final WeatherClient weatherClient;
    private final String apikey;

    public WeatherService(WeatherClient weatherClient, @Property(name = "openweather.apikey") String apikey) {
        this.weatherClient = weatherClient;
        this.apikey = apikey;
    }


    @Cacheable
    public WeatherInfo getWeather(TemperatureUnit temperatureUnit, double latitude, double longitude) {
        var result = weatherClient.get(latitude, longitude, null, temperatureUnit, apikey);
        return new WeatherInfo(temperatureUnit, 
        Math.round(result.getCurrent().getTemp()),
        Math.round(result.getDaily().get(0).getTemp().getMin()),
        Math.round(result.getDaily().get(0).getTemp().getMax()),
        result.getCurrent().getWeather().get(0).getId());
    }

}
