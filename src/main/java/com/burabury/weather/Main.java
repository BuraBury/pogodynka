package com.burabury.weather;

import com.burabury.weather.forecastSources.openweather.OpenWeather;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        OpenWeather op = new OpenWeather("731e8be40ca8b8209df56902d2842e00");
        String weather = op.getForecast(50.041187, 21.999121, LocalDate.now());
        System.out.println(weather);


    }
}
