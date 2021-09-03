package watchy_api.services;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import watchy_api.models.TemperatureUnit;

/**
 * https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
 * @author edward
 */
 @Client("https://api.openweathermap.org/data/2.5/onecall")
public interface WeatherClient {
    @Get
    OneCallResult get(
        @QueryValue("lat") double latitude, 
        @QueryValue("lon") double longitude,
        @QueryValue(value="exclude", defaultValue="minutely,hourly,alerts") String exclude,
        TemperatureUnit temperatureUnit,
        @QueryValue(value="appid") String apikey
        );
}
