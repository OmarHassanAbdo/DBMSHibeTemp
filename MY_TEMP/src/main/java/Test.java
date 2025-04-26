import DAO.DBCourse;
import DAO.DBDepartment2;
import DAO.DBStudents;
import criteria.FilterQuery;
import criteria.Operator;
import models.*;
import models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        DBStudents db = new DBStudents();
//        //---------------------------------------
//        //getting all the students
//        List<Department2>students = new DBDepartment2().getAll();
//        for(Department2 c :students){
//            System.out.println(c.getName());
//            System.out.println(c.getId());
        //}
        //---------------------------------------
        //getting student by Id
//        System.out.println(db.getByID(2));
        //---------------------------------------
        //creating new student
//        Student s = new Student();
//        s.setName("saied");
//        s.setAge(20);
//        s.setAdress("blablabla");
//        s.setJoined_date(new Date());
//        System.out.println("the new student id: "+db.createStudent(s));
//        st = db.get();
//        for(Student e : st){
//            System.out.println(e);
//        }
        //---------------------------------------
        //updating an exsisting student
//        System.out.println(db.getByID(1));
//        Student firstStudent = db.getByID(1);
//        firstStudent.setAge(40);
//        db.update(firstStudent);
//        System.out.println(db.getByID(1));
        //---------------------------------------
        //deleting a student
//        for(Student e : st){
//            System.out.println(e);
//        }
//        db.delete(14);
//        st = db.get();
//        for(Student e : st){
//            System.out.println(e);
//        }
        DBStudents dbStudent = new DBStudents();
        //LocalDate date=LocalDate.of(2015,1,1);
        List<FilterQuery> filterQueries = new ArrayList<>();
//        filterQueries.add(new FilterQuery("id", 0, Operator.GT));
//        filterQueries.add(new FilterQuery("name", "Hazem", Operator.EQ));
//        filterQueries.add(new FilterQuery("age", 22, Operator.LT));
        //filterQueries.add(new FilterQuery("joined_date",date , Operator.GT));
//        filterQueries.add(new FilterQuery("name","__z%" , Operator.LIKE));
//        List<Integer> comparators = new ArrayList<>();
//        comparators.add(new Integer(1));
//        comparators.add(new Integer(3));
//        filterQueries.add(new FilterQuery("studentId" , comparators, Operator.BET));
//        List<Integer> in = new ArrayList<>();
//        in.add(1);
//        in.add(2);
//        filterQueries.add(new FilterQuery("studentId" , in , Operator.IN ));
        filterQueries.add(new FilterQuery("dep_id" , null , Operator.ISNULL));
        System.out.println(  dbStudent.getByFilter(filterQueries));
    }
}
