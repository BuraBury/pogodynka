package weatherApp.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import weatherApp.DatabaseConfig;
import weatherApp.model.CachedForecast;
import weatherApp.model.WeatherSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CachedForecastDao {

    public void saveForecast(CachedForecast forecast) {
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(forecast);
            transaction.commit();
        }

    }

    @SuppressWarnings("unchecked")
    public List<CachedForecast> listForecast() {
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {

            return (List<CachedForecast>) session
                    .createQuery("select f from CachedForecast f").list();
        }
    }

    public CachedForecast findWeatherForecastForLocalization(WeatherSource source, String localization, LocalDate date) {
       LocalDateTime todayMidnight = LocalDate.now().atStartOfDay();
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            List<CachedForecast> forecasts = session
                    .createQuery("select f from CachedForecast f where " +
                            "f.source = :source and f.localization = :localization and f.date = :date" +
                            "and f.created > :todayMidnight")
                    .setParameter("source", source)
                    .setParameter("localization", localization)
                    .setParameter("date", date)
                    .setParameter("todayMidnight", todayMidnight)
                    .list();
            return forecasts.stream().findFirst().orElse(null);
        }
    }
}
