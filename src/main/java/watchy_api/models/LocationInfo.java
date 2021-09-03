package watchy_api.models;

import io.micronaut.core.annotation.Introspected;

/**
 *
 * @author edward
 */
 @Introspected
public class LocationInfo {
    private final String timezone;
    private final double latitude;
    private final double longitude;

    public LocationInfo(String timezone, double latitude, double longitude) {
        this.timezone = timezone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


}
