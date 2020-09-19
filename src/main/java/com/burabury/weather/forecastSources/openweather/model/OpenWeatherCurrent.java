package com.burabury.weather.forecastSources.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherCurrent {
    double temp;
    double pressure;
    double humidity;
    @JsonProperty("wind_speed") //poprawianie nazwy
    double windSpeed;
    @JsonProperty("wind_deg")
    double windDegree;

    public OpenWeatherCurrent(double temp, double pressure, double humidity, double windSpeed, double windDegree) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
    }

    public OpenWeatherCurrent() {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(double windDegree) {
        this.windDegree = windDegree;
    }

    @Override
    public String toString() {
        return "\ncurrent weather: " +
                "\ntemp=" + temp +
                ",\npressure=" + pressure +
                ",\nhumidity=" + humidity +
                ",\nwind_speed=" + windSpeed +
                ",\nwind_deg=" + windDegree +
                '}';
    }
}


