package com.burabury.weather.forecastSources.openweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherDaily implements DateConverter{

    @JsonProperty("temp")
    private TemperatureDetails temperatureDetails;
    private double pressure;
    private double humidity;
    @JsonProperty("dt")
    private long dateTime;
    @JsonProperty("wind_speed") //poprawianie nazwy
    private double windSpeed;
    @JsonProperty("wind_deg")
    double windDegree;


    public OpenWeatherDaily() {
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
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
        return "\nDaily weather" +
                "\ndateTime=" + convertDate(getDateTime()) +
                "\n" + getTemperatureDetails() +
                "\npressure=" + pressure +
                ",\nhumidity=" + humidity +
                ",\nwindSpeed=" + windSpeed +
                ",\nwindDegree=" + windDegree + "\n";
    }
}


