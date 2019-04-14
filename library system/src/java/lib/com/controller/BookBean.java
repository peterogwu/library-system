package lib.com.controller;

import lib.com.model.Books;
import lib.com.service.BookService;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

/**
*
* @author Peter Ogwu
*/
@Named(value = "bookBean")
@RequestScoped
public class BookBean {

private String title;
private String id;
private String author;
private String isbn;
private String publisher;
private String country;
private String sex;



private String message;
//private String search;
//private List<Books> allUser;
private boolean render = false;
@Autowired
private BookService bookService;

public BookBean() {
}

//persisting Book object
public String save() 
throws SQLException {
bookService.save(title, author, isbn,publisher,country,sex);
setMessage("New book was added");
return "index?faces-redirect=true";
}


//retreiving all Books from database
public List<Books> getAllBooks() {
return bookService.viewBooks();
}


//this method sets the visibility of the dataTable
public void activate() {
setRender(true);
}
//Updating
public String update() {
int bookId = Integer.parseInt(id);
bookService.updateBook(bookId);
return "index?faces-redirect=true";
}

//Saerching book by ID
public String searchById(){
int bookId = Integer.parseInt(id);
bookService.findById(bookId);
return "application_form?faces-redirect=true";
}

//Searching by Id ...this method is called from the dataTable which passes the Id of the particular book that should be viewed
public String findById(int id) {
bookService.findById(id);
return "application_form?faces-redirect=true";
}


//Delete Book
public String delete() {
int bookId = Integer.parseInt(id);
bookService.deleteBook(bookId);
return "index?faces-redirect=true";
}


//Queryin the Db using name of the book
public String findByName() {
bookService.findByName(country);
return "application_form?faces-redirect=true";
}


//public void reset() {
//this.books.setId(0);
//this.books.setTitle("");
//this.books.setAuthor("");
//this.books.setIsbn("");
//this.books.setPublisher("");
//this.books.setcountry("");
//this.books.setSex("");
//}
//  





//Getters and Setter
public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getAuthor() {
return author;
}

public void setAuthor(String author) {
this.author = author;
}


public String getIsbn() {
return isbn;
}

public void setIsbn(String isbn) {
this.isbn = isbn;
}



public String getPublisher() {
return publisher;
}

public void setPublisher(String publisher) {
this.publisher = publisher;
}


public String getCountry() {
return country;
}

public void setCountry(String country) {
this.country = country;
}


public String getSex() {
return sex;
}

public void setSex(String sex) {
this.sex = sex;
}






//public String getSearch() {
//return search;
//}
//
//public void setSearch(String search) {
//this.search = search;
//}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}
//
//public List<Books>getAllUser() {
//return allUser;
//}
//
//public void setAllUser(List<Books> allUser) {
//this.allUser = allUser;
//}

public boolean isRender() {
return render;
}

public void setRender(boolean render) {
this.render = render;
}

  




    

}
