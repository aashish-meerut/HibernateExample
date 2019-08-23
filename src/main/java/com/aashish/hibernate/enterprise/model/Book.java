package com.aashish.hibernate.enterprise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book
{
    @Id
    @GeneratedValue
    @Column(name="BOOK_ID")
    private int bookId;
    
    @Column(name="BOOK_TITLE")
    private String bookTitle;
    
    @Column(name="BOOK_DESCRIPTION")
    private String bookDescription;
    
    @ManyToOne
    @JoinColumn(name="AUTHOR_ID")
    private Author author;

    public Book()
    {
        super();
    }

    public Book(int bookId, String bookTitle, String bookDescription, Author author)
    {
        super();
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.author = author;
    }

    public int getBookId()
    {
        return bookId;
    }

    public void setBookId(int bookId)
    {
        this.bookId = bookId;
    }

    public String getBookTitle()
    {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle)
    {
        this.bookTitle = bookTitle;
    }

    public String getBookDescription()
    {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription)
    {
        this.bookDescription = bookDescription;
    }

    public Author getAuthor()
    {
        return author;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookDescription=" + bookDescription
                + ", author=" + author + "]";
    }
}
