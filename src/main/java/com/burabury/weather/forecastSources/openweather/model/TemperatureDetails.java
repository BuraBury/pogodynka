package com.burabury.weather.forecastSources.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureDetails {

    private double day;
    private double night;
    private double min;
    private double max;
    private double eve;
    private double morn;

    public TemperatureDetails() {
    }

    public double getDay() {
        return day;
    }

    public void setDay(double day) {
        this.day = day;
    }

    public double getNight() {
        return night;
    }

    public void setNight(double night) {
        this.night = night;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getEve() {
        return eve;
    }

    public void setEve(double eve) {
        this.eve = eve;
    }

    public double getMorn() {
        return morn;
    }

    public void setMorn(double morn) {
        this.morn = morn;
    }

    @Override
    public String toString() {
        return "TemperatureDetails{" +
                "\nday=" + day +
                ",\nnight=" + night +
                ",\nmin=" + min +
                ",\nmax=" + max +
                ",\neve=" + eve +
                ",\nmorn=" + morn +
                '}';
    }
}
