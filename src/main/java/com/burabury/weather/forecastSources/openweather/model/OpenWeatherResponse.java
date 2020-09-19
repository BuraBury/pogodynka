package com.burabury.weather.forecastSources.openweather.model;

import com.burabury.weather.forecastSources.openweather.model.OpenWeatherCurrent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse {

    private double lat;
    private double lon;
    private OpenWeatherCurrent current;

    public OpenWeatherResponse(double lat, double lon, OpenWeatherCurrent current) {
        this.lat = lat;
        this.lon = lon;
        this.current = current;
    }

    public OpenWeatherResponse() {
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public OpenWeatherCurrent getCurrent() {
        return current;
    }

    public void setCurrent(OpenWeatherCurrent current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "OpenWeatherForcastResponse{" +
                "lat=" + lat +
                ", lon=" + lon +
                current +
                '}';
    }
}
