package DAO;

import criteria.FilterQuery;
import models.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DBStudents {

    public List<Student> getByFilter(List<FilterQuery> filterQueries) {

        try (Session session = DBConfig.sessionFactory.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Student> cr = cb.createQuery(Student.class);
            Root<Student> root = cr.from(Student.class);
            cr.select(root);

            Predicate[] predicates = new Predicate[filterQueries.size()];
            for (int i = 0; i < filterQueries.size(); i++) {
                switch (filterQueries.get(i).getOp()) {
                    case EQ:
                        predicates[i]= cb.equal(root.get(filterQueries.get(i).getField()), filterQueries.get(i).getValue());
                        break;
                    case NEQ:
                        predicates[i] = cb.notEqual(root.get(filterQueries.get(i).getField()), filterQueries.get(i).getValue());
                        break;
                    case GT:
                        predicates[i]= cb.greaterThan(root.get(filterQueries.get(i).getField()), (Comparable)filterQueries.get(i).getValue());
                        break;
                    case LT:
                        predicates[i]= cb.lessThan(root.get(filterQueries.get(i).getField()), (Comparable)filterQueries.get(i).getValue());
                        break;
                    case BET:
                        List<Comparable> value =
                                (List<Comparable>) filterQueries.get(i).getValue();
                        predicates[i] = cb.between(root.get(filterQueries.get(i).getField()) , value.get(0), value.get(1));
                        break;
                    case IN:
                        List<Object> inquery =
                                (List<Object>) filterQueries.get(i).getValue();
                        predicates[i] = root.get(filterQueries.get(i).getField()).in(inquery);
                        break;
                    case LIKE:
                        predicates[i] =
                                cb.like(root.get(filterQueries.get(i).getField()),  (String) filterQueries.get(i).getValue());
                        break;
                    case ISNULL:
                        predicates[i] = cb.isNull(root.get(filterQueries.get(i).getField()));
                        break;
                    case GE:
                        predicates[i] = cb.greaterThanOrEqualTo(root.get(filterQueries.get(i).getField()), (Comparable)filterQueries.get(i).getValue());
                        break;
                        case LE:
                            predicates[i] = cb.lessThanOrEqualTo(root.get(filterQueries.get(i).getField()), (Comparable)filterQueries.get(i).getValue());
                            break;
                    default:
                        break;

                }
            }

            cr.select(root).where(predicates);


            Query<Student> query = session.createQuery(cr);

            return query.getResultList();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return new ArrayList<>();
    }


    public List<Student> get(){
        try(Session session = DBConfig.sessionFactory.openSession()){
            return session.createQuery("from Student").list();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public Student getByID(Integer id){
        try(Session session = DBConfig.sessionFactory.openSession()){
            return session.get(Student.class , id);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public Integer createStudent(Student student){
        Transaction tx = null ;
        Integer id = null;
        try(Session session = DBConfig.sessionFactory.openSession()){
            tx = session.beginTransaction();
            session.save(student);
            id = student.getId();
            tx.commit();
        }
        catch(Exception e){
            if(tx!= null){
                tx.rollback();
            }
            System.err.println(e.getMessage());
        }
        return id;
    }
    public void update(Student student){
        Transaction tx = null ;
        try(Session session = DBConfig.sessionFactory.openSession()){
            tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        }
        catch(Exception e){
            if(tx!= null){
                tx.rollback();
            }
            System.err.println(e.getMessage());
        }
    }
    public void delete(Integer id){
        Transaction tx = null ;
        try(Session session = DBConfig.sessionFactory.openSession()){
            tx = session.beginTransaction();
            Student student = getByID(id);
            session.delete(student);
            tx.commit();
        }
        catch(Exception e){
            if(tx!= null){
                tx.rollback();
            }
            System.err.println(e.getMessage());
        }
    }
}
