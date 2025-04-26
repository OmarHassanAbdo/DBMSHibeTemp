package DAO;

import models.*;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import DAO.DBConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBDepartment2 {

    public List<Department2> getAll() {

        try (Session session = DBConfig.sessionFactory.openSession()) {

            return session.createQuery("FROM Department2").list();

//      return session.createSQLQuery("select * from students").addEntity(Student.class).list();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return null;
    }

}
