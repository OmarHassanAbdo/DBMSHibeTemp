package DAO;


import models.*;
import org.hibernate.Session;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;

public class DBCourse {
    public List<Course> getAll() {

        try (Session session = DBConfig.sessionFactory.openSession()) {

            return session.createQuery("FROM Course").list();

//      return session.createSQLQuery("select * from students").addEntity(Student.class).list();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

}
