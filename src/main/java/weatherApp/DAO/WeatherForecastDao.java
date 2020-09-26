package weatherApp.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import weatherApp.DatabaseConfig;
import weatherApp.model.WeatherForecast;

import java.util.List;

public class WeatherForecastDao {

    public void saveForecast(WeatherForecast forecast) {
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(forecast);
            transaction.commit();
        }

    }

    @SuppressWarnings("unchecked")
    public List<WeatherForecast> listForecast() {
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {

            return (List<WeatherForecast>) session
                    .createQuery("select w from WeatherForecast w").list();
        }
    }

}


