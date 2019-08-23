package com.aashish.hibernate.enterprise.one;

import org.hibernate.Session;
import java.util.*;

import model.Address;
import model.Student;

//One-To-One Unidirectional with Foreign Key Associations.
public class HibernateOneToOne {
	   @SuppressWarnings("unchecked")
	    public static void main(String[] args) {
	 
	        Student student = new Student("Sam","Disilva","Maths");
	        Address address = new Address("10 Silver street","NYC","USA");
	         
	         
	        Session session = Util.giveSession();
	        session.beginTransaction();
	 
	        session.persist(address);
	        student.setAddress(address);
	        session.persist(student);
	 
	        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
	        System.out.println("Total records : "+students.size());
	        for(Student s: students){
	            System.out.println("Details  First name : "+s.getFirstName());
	            System.out.println("Details  Address : "+s.getAddress().getCity());
	        }
	         
	        session.getTransaction().commit();
	        session.close();  
	    }

}
