package weatherApp.openWeather;

import com.fasterxml.jackson.databind.ObjectMapper;
import weatherApp.DAO.CachedForecastDao;
import weatherApp.model.CachedForecast;
import weatherApp.model.WeatherForecast;
import weatherApp.model.WeatherSource;
import weatherApp.openWeather.model.Coords;
import weatherApp.openWeather.model.OpenWeatherDailyForecast;
import weatherApp.openWeather.model.OpenWeatherResponse;
import weatherApp.openWeather.model.OpenWeatherWeatherResponse;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class OpenWeather {

    private final static String URI_PATTERN = "https://api.openweathermap.org/data/2.5/onecall?lat=%f&lon=%f&exclude=minutely,hourly&units=metric&appid=%s";
    private final static String CITY_PATTERN = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    private final static ObjectMapper MAPPER = new ObjectMapper();

    private final String key;
    private final CachedForecastDao cache;


    public OpenWeather(String key) {
        this.key = key;
        this.cache = new CachedForecastDao();
    }

    public WeatherForecast getForecast(String city) {
        return getForecast(city, getTomorrow());
    }

    public WeatherForecast getForecast(String city, LocalDate date) {
        try {
            String uri = String.format(CITY_PATTERN, city, key);
            String response = Request.Get(uri)
                    .execute().returnContent().asString();
            Coords coords = MAPPER.readValue(response, OpenWeatherWeatherResponse.class).getCoord();
            return getForecast(coords.getLat(), coords.getLon(), date);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public WeatherForecast getForecast(double lat, double lon) {
        return getForecast(lat, lon, getTomorrow());
    }

    public WeatherForecast getForecast(double lat, double lon, LocalDate date) {
        CachedForecast previousForecast = findCachedForecast(lat, lon, date);
        if (previousForecast != null) {
            System.out.println("Returning cached result!");
            return previousForecast.getForecast();
        }
        System.out.println("Using openWeather to get forecast");
        WeatherForecast weatherForecast = findOpenWeatherForecast(lat, lon, date);

        saveCachedForecast(weatherForecast, lat, lon, date);
        return weatherForecast;
    }

    private CachedForecast findCachedForecast(double lat, double lon, LocalDate date) {
       return cache.findWeatherForecastForLocalization(WeatherSource.OPEN_WEATHER, getLocalization(lat, lon), date);
    }
    private CachedForecast findCachedForecast(String city, LocalDate date) {
        return cache.findWeatherForecastForLocalization(WeatherSource.OPEN_WEATHER, city, date);
    }


    private WeatherForecast findOpenWeatherForecast(double lat, double lon, LocalDate date) {
        try {
            String uri = String.format(URI_PATTERN, lat, lon, key);

            String response = Request.Get(uri)
                    .execute().returnContent().asString();
            OpenWeatherResponse openWeatherResponse = MAPPER.readValue(response, OpenWeatherResponse.class);
            OpenWeatherDailyForecast forecastForDate = findForecastForDate(openWeatherResponse.getDaily(), date);
            return WeatherForecastMapper.fromOpenWeather(forecastForDate);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void saveCachedForecast(WeatherForecast weatherForecast, double lat, double lon, LocalDate date) {
        CachedForecast cachedForecast = new CachedForecast(weatherForecast, getLocalization(lat, lon), WeatherSource.OPEN_WEATHER, date);
        cache.saveForecast(cachedForecast);
    }


    private String getLocalization(double lat, double lon) {
        return String.format("%f;%f", lat, lon);
    }


    private OpenWeatherDailyForecast findForecastForDate(List<OpenWeatherDailyForecast> dailyForecasts, LocalDate date) {
        return dailyForecasts.stream()
                .filter(forecast -> date.equals(Instant.ofEpochSecond(forecast.getDateTime())
                        .atZone(ZoneId.systemDefault()).toLocalDate()))
                .findAny()
                .orElse(null);
    }

    private LocalDate getTomorrow() {
        return LocalDate.now().plusDays(1);
    }
}