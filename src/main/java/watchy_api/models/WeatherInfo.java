package watchy_api.models;

import io.micronaut.core.annotation.Introspected;

/**
 *
 * @author edward
 */
 @Introspected
public class WeatherInfo {
       private final TemperatureUnit temperatureUnit;
       private final int currentTemperature;
       private final int lowTemperature;
       private final int highTemperature;
       private final int weatherConditionCode;

    public WeatherInfo(TemperatureUnit temperatureUnit, int currentTemperature, int lowTemperature, int highTemperature, int weatherConditionCode) {
        this.temperatureUnit = temperatureUnit;
        this.currentTemperature = currentTemperature;
        this.lowTemperature = lowTemperature;
        this.highTemperature = highTemperature;
        this.weatherConditionCode = weatherConditionCode;
    }

    public TemperatureUnit getTemperatureUnit() {
        return temperatureUnit;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public int getLowTemperature() {
        return lowTemperature;
    }

    public int getHighTemperature() {
        return highTemperature;
    }

    public int getWeatherConditionCode() {
        return weatherConditionCode;
    }
    


}
