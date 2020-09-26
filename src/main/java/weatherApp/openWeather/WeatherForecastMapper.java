package weatherApp.openWeather;

import weatherApp.model.WeatherForecast;
import weatherApp.openWeather.model.OpenWeatherDailyForecast;

public class WeatherForecastMapper {
    public static WeatherForecast fromOpenWeather(OpenWeatherDailyForecast forecast) {
        WeatherForecast result = new WeatherForecast();
        result.setHumidity(forecast.getHumidity());
        result.setPressure(forecast.getPressure());
        result.setTemperature(forecast.getTemp());
        result.setWindDegree(forecast.getWindDegree());
        result.setWindSpeed(forecast.getWindSpeed());
        return result;
    }
}
