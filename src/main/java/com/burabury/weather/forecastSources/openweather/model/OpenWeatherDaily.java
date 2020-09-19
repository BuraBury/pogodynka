package com.burabury.weather.forecastSources.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDaily {

    @JsonProperty("temp")
    private TemperatureDetails temperatureDetails;
    private double pressure;
    private double humidity;

    @JsonProperty("dt")
    private long date;

    @JsonProperty("wind_speed") //poprawianie nazwy
            double windSpeed;

    @JsonProperty("wind_deg")
    double windDegree;

    public OpenWeatherDaily() throws JsonProcessingException {
    }

    public Date getDate() {

        Date resultDate = new Date(date);
        return resultDate;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public TemperatureDetails getTemperatureDetails() {
        return temperatureDetails;
    }

    public void setTemperatureDetails(TemperatureDetails temperatureDetails) {
        this.temperatureDetails = temperatureDetails;
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


    public String toString() {
        return "\n\nOpenWeatherDaily{\n"
                + date + "\n"
                + temperatureDetails +
                ",\npressure=" + pressure +
                ",\nhumidity=" + humidity +
                ",\nwindSpeed=" + windSpeed +
                ",\nwindDegree=" + windDegree +
                '}' + "\n";
    }
}


