package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConfig {

    public static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
