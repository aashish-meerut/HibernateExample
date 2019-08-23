package com.aashish.hibernate.enterprise.one;


import java.util.HashSet;
import java.util.Set;

import model.Author;
import model.Book;

import org.hibernate.Session;

public class HibernateOneToMany_new
{
    public static void main(String args[])
    {
    	Session session=  Util.giveSession();
        
        //Begin the transaction
        session.beginTransaction();
       // savedata(session);
        getdata(session);
        
        //Close the session
        session.close();
    }
    
    public static void savedata(Session session){
    	//Create a new Author Object
        Author author = new Author();
        author.setAuthorName("Aashish Kumar");

        //Create a new Book Object        
        Book book1 = new Book();
        book1.setBookTitle("Hibernate  aaa");
        book1.setBookDescription("Hibernate Description  ssssss");
        book1.setAuthor(author);

        //Create a new Book Object        
        Book book2 = new Book();
        book2.setBookTitle("Spring  2222  ");
        book2.setBookDescription("Spring Descriptioneeeeeee");
        book2.setAuthor(author);
        
        //Adding books to the Set
        Set<Book> books = new HashSet();
        books.add(book1);
        books.add(book2);
        author.setBooks(books);
       
        session.save(author);
             
        //Commit the changes
        session.getTransaction().commit();
    	
    }
    public  static void getdata(Session session){
    	 Book b1 = (Book) session.load(Book.class,11);
         System.out.println( "Book Description "     +b1.getBookDescription()+ " --------Book Author---------- "+b1.getAuthor().getAuthorName());  
    
    	
    }
}
