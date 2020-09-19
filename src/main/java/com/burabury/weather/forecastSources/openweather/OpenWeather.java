package com.burabury.weather.forecastSources.openweather;

import com.burabury.weather.forecastSources.openweather.model.OpenWeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.time.LocalDate;

public class OpenWeather {

    private final static String URI_PATTERN = "https://api.openweathermap.org/data/2.5/" +
            "onecall?lat=%f&lon=%f&exclude=minutely,hourly&units=metric&appid=%s";
    private final String key;

    private final static ObjectMapper mapper = new ObjectMapper();

    public OpenWeather(String key) {
        this.key = key;
    }

    public String getCurrentForecast(double lat, double lon) {
       LocalDate date =  LocalDate.now();
        try {
            String uri = String.format(URI_PATTERN, lat, lon, key);
            String result = Request.Get(uri)
                    .execute()
                    .returnContent()
                    .asString();
            return date.toString() + mapper.readValue(result, OpenWeatherResponse.class).getCurrent();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public String getDailyForecastForWeek(double lat, double lon, LocalDate date) {
        try {
            String uri = String.format(URI_PATTERN, lat, lon, key);
            String result = Request.Get(uri)
                    .execute()
                    .returnContent()
                    .asString();
            return String.valueOf(mapper.readValue(result, OpenWeatherResponse.class).getDaily());
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
