package com.burabury.weather.forecastSources.openweather.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface DateConverter {

    default String convertDate(long dateToConvert) {
        Date date = new Date(dateToConvert);
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
        String dateText = df2.format(date);

        return dateText;
    }

}
