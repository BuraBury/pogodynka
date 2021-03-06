package weatherApp;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import weatherApp.model.CachedForecast;
import weatherApp.model.WeatherForecast;

import java.util.Properties;

//uzyskanie dostepu do bazy danych
public class DatabaseConfig {

    static SessionFactory sessionFactory;

    private static Properties getSettings() {
        Properties settings = new Properties();

        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/EMP?serverTimezone=EST");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        return settings;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperties(getSettings());

        //dodanie encji do hibernate, skanuj te klase
        configuration.addAnnotatedClass(WeatherForecast.class);
        configuration.addAnnotatedClass(CachedForecast.class);


        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

}


