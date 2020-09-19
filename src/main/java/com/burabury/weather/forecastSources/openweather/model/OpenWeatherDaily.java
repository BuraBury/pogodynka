package com.burabury.weather.forecastSources.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDaily {

    List<Object> dailyWeather = new ArrayList();
    long dt;

    public OpenWeatherDaily() {
    }

    public List<Object> getDailyWeather() {
        return dailyWeather;
    }

    public void setDailyWeather(List<Object> dailyWeather) {
        this.dailyWeather = dailyWeather;
    }


}
