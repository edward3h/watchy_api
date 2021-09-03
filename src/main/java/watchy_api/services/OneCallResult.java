package watchy_api.services;
import io.micronaut.core.annotation.Introspected;
import java.util.List;
import watchy_api.services.OneCallResult.CurrentWeather;
import watchy_api.services.OneCallResult.DailyWeatherTemp;

/**
 * https://openweathermap.org/api/one-call-api
 * @author edward
 */
 @Introspected
public class OneCallResult {
    private CurrentWeather current;
    private List<DailyWeather> daily;

    public CurrentWeather getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }

    public List<DailyWeather> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyWeather> daily) {
        this.daily = daily;
    }


    public static class CurrentWeather {
        private float temp;
        private List<WeatherCondition> weather;

        public float getTemp() {
            return temp;
        }

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public List<WeatherCondition> getWeather() {
            return weather;
        }

        public void setWeather(List<WeatherCondition> weather) {
            this.weather = weather;
        }

    }

    public static class DailyWeather {
        private DailyWeatherTemp temp;

        public DailyWeatherTemp getTemp() {
            return temp;
        }

        public void setTemp(DailyWeatherTemp temp) {
            this.temp = temp;
        }

    }

    public static class DailyWeatherTemp {
        private float min;
        private float max;

        public float getMin() {
            return min;
        }

        public void setMin(float min) {
            this.min = min;
        }

        public float getMax() {
            return max;
        }

        public void setMax(float max) {
            this.max = max;
        }

    }

    public static class WeatherCondition {
        
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
