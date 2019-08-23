package com.aashish.hibernate.enterprise.one;

import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.Student_Info;
import model.University;
 
public class HibernateManytoOne {
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
 
    	Student_Info student1 = new Student_Info("Sam", "Disilva", "Maths");
    	Student_Info student2 = new Student_Info("Joshua", "Brill", "Science");
    	Student_Info student3 = new Student_Info("Peter", "Pan", "Physics");
 
    //    University university = new University("CAMBRIDGE", "ENGLAND");
        University university = new University("CCS", "INDIA");
        List<Student_Info> allStudents = new ArrayList<Student_Info>();
 
        student1.setUniversity(university);
        student2.setUniversity(university);
        student3.setUniversity(university);
 
        allStudents.add(student1);
        allStudents.add(student2);
        allStudents.add(student3);
 
        university.setStudents(allStudents);
      //  university2.setStudents(allStudents);

        //Reading the hibernate configuration file
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder regBuilber = new StandardServiceRegistryBuilder();
        regBuilber.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = regBuilber.build();
        
        //Create SessionFacctory
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        //Create Session from SessionFactory
        Session session = sessionFactory.openSession();
        
        //Begin the transaction
        session.beginTransaction();
        session.persist(university);// Students will be presisted automatically, thanks to CASCADE.ALL defined on students
                                    // property of University class.
     //   session.persist(university2);
        List<Student_Info> students = (List<Student_Info>) session.createQuery(
                "from Student_Info ").list();
        for (Student_Info s : students) {
            System.out.println("Student Details : " + s);
            System.out.println("Student University Details: "
                    + s.getUniversity());
            if(s.getUniversity().getName().equals("CAMBRIDGE")){
            	
            	//session.delete(students);
            }
        }
 
        
        
        // Note that now you can also access the relationship from University to Student
 
        session.getTransaction().commit();
        session.close();
    }
 
}
