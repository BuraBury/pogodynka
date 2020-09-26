package weatherApp.model;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CachedForecast {

    public CachedForecast() {
    }

    public CachedForecast(WeatherForecast forecast, String localization, WeatherSource source, LocalDate date) {
        this.forecast = forecast;
        this.localization = localization;
        this.source = source;
        this.date = date;
        this.created = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private WeatherForecast forecast;

    private String localization;
    private WeatherSource source;
    private LocalDate date;
    private LocalDateTime created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WeatherForecast getForecast() {
        return forecast;
    }

    public void setForecast(WeatherForecast forecast) {
        this.forecast = forecast;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public WeatherSource getSource() {
        return source;
    }

    public void setSource(WeatherSource source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "CachedForecast{" +
                "id=" + id +
                ", forecast=" + forecast +
                ", localization='" + localization + '\'' +
                ", source=" + source +
                ", date=" + date +
                ", created=" + created +
                '}';
    }
}

