package com.burabury.weather.forecastSources.openweather.model;

import com.burabury.weather.forecastSources.openweather.OpenWeather;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureDetails {

    double temp;

    public TemperatureDetails() {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public String toString() {
        return "\ntemp=" + temp;
    }
}
