package watchy_api.models;

import io.micronaut.core.annotation.Introspected;

/**
 *
 * @author edward
 */
@Introspected
public class WatchyInfo {
       private final long localTimeEpoch;
       private final TemperatureUnit temperatureUnit;
       private final int currentTemperature;
       private final int lowTemperature;
       private final int highTemperature;
       private final int weatherConditionCode;

    public WatchyInfo(long localTimeEpoch, TemperatureUnit temperatureUnit, int currentTemperature, int lowTemperature, int highTemperature, int weatherConditionCode) {
        this.localTimeEpoch = localTimeEpoch;
        this.temperatureUnit = temperatureUnit;
        this.currentTemperature = currentTemperature;
        this.lowTemperature = lowTemperature;
        this.highTemperature = highTemperature;
        this.weatherConditionCode = weatherConditionCode;
    }

    public long getLocalTimeEpoch() {
        return localTimeEpoch;
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
