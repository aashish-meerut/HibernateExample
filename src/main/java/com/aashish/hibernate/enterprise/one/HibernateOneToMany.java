package com.aashish.hibernate.enterprise.one;


import java.util.HashSet;
import java.util.Set;

import model.Author;
import model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateOneToMany
{
    public static void main(String args[])
    {
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
        
        //Create a new Author Object
        Author author = new Author();
        author.setAuthorName("JavaInterviewPoint");

        //Create a new Book Object        
        Book book1 = new Book();
        book1.setBookTitle("Hibernate");
        book1.setBookDescription("Hibernate Description");
        book1.setAuthor(author);

        //Create a new Book Object        
        Book book2 = new Book();
        book2.setBookTitle("Spring");
        book2.setBookDescription("Spring Description");
        book2.setAuthor(author);
        
        //Adding books to the Set
        Set<Book> books = new HashSet();
        books.add(book1);
        books.add(book2);
        author.setBooks(books);
       
        session.save(author);
             
        //Commit the changes
        session.getTransaction().commit();
        //Close the session
        session.close();
    }
}
