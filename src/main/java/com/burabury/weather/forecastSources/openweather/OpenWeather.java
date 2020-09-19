package com.burabury.weather.forecastSources.openweather;

import com.burabury.weather.forecastSources.openweather.model.OpenWeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.time.LocalDate;

public class OpenWeather {

    private final static String URI_PATTERN = "https://api.openweathermap.org/data/2.5/" +
            "onecall?lat=%f&lon=%f&exclude=minutely,hourly&units=metric&appid=%s";
    private final static ObjectMapper mapper = new ObjectMapper();

    private final String key;

    public OpenWeather(String key) {
        this.key = key;
    }

    public String getForecast(double lat, double lon) {
        try {
            String uri = String.format(URI_PATTERN, lat, lon, key);
            String result = Request.Get(uri)
                    .execute()
                    .returnContent()
                    .asString();
            return String.valueOf(mapper.readValue(result, OpenWeatherResponse.class));
        } catch (IOException e) {
            return e.getMessage();
        }


    }
}
