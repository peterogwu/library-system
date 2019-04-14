package lib.com.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
*
* @author Peter Ogwu
*/
@Entity
public class Books implements Serializable {

private int id;
private String title;
private String author;
private String isbn;
private String publisher;
private String country;
private String sex;

public Books() {
}
 
 
public Books(int id){
    this.id=id;
}
public Books(String title, String author, String isbn,String publisher,String country,String sex) {
this.title = title;
this.author = author;
this.isbn = isbn;
this.publisher = publisher;
this.country = country;
this.sex = sex;

}

//public Books(String title, String author, String isbn, String publisher, String country, String sex) {
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//}



@Id
@Column(name="id", length=45,nullable=false,unique = true)
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}




@Column(name="author" )
public String getAuthor() {
return author;
}

public void setAuthor(String author) {
this.author = author;
}



@Column(name="title")
public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}


@Column(name="isbn")
public String getIsbn() {
return isbn;
}

public void setIsbn(String isbn) {
this.isbn = isbn;
}


@Column(name="publisher")
public String getPublisher() {
return publisher;
}

public void setPublisher(String publisher) {
this.publisher = publisher;
}

@Column(name="country")
public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country= country;

}

@Column(name="sex", length=30)
public String getSex() {
return this.sex;
}
public void setSex(String sex) {
this.sex = sex;
}



//public void reset() {
//		this.setId(0);
//		this.setTitle ("");
//                this.setAuthor("");
//                this.setPublisher("");
//                this.setCountry("");
//                this.setSex("");
//
//}


//This method writes the values of contact object with System.out.println(customer.toString()) code
    @Override
    public String toString() {
    return "Books"
    + "\n\t Id: " + this.id   
    + "\n\t Title: " + this.title     
    + "\n\t Isbn: " + this.author
    + "\n\t Publisher: " + this.publisher
    + "\n\t Country: " + this.country
    + "\n\t Sex: " + this.sex;
}
}




