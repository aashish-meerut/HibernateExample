package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AUTHOR")
public class Author
{
    @Id
   // @GeneratedValue
    
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
    
    
    
    
    @Column(name="AUTHOR_ID")
    private int authorId;
    
    @Column(name="AUTHOR_NAME")
    private String authorName;
    
    @OneToMany(mappedBy="author",cascade = CascadeType.ALL)
    private Set<Book> books;
    
    public Author()
    {
        super();
    }

    public Author(int authorId, String authorName, Set books)
    {
        super();
        this.authorId = authorId;
        this.authorName = authorName;
        this.books = books;
    }

    public int getAuthorId()
    {
        return authorId;
    }

    public void setAuthorId(int authorId)
    {
        this.authorId = authorId;
    }

    public String getAuthorName()
    {
        return authorName;
    }

    public void setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }
/*
    @Override
    public String toString()
    {
        return "Author [authorId=" + authorId + ", authorName=" + authorName + ", books=" + books + "]";
    }
    */
}
