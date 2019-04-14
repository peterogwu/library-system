package lib.com.service;

import lib.com.controller.BookBean;
import lib.com.model.Books;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @author Peter Ogwu
*/
@Service
@Transactional
public class BookService {

@Autowired
private BookBean bookBean; //autowired the backing bean class
@Autowired
private SessionFactory sessionFactory;//autowired the sessionfactory class
Books book;
private Session session;
private Query query;
int quryResult = 0;
int role = 0;

public void save(String title, String author, String isbn,String publisher, String country, String sex )
throws SQLException {
book = new Books(title, author,isbn,publisher,country,sex);
session = sessionFactory.getCurrentSession();
session.save(book);
}



//This method lists all the books on Db
public List<Books> viewBooks() {
List<Books> bookList = null;
try {

session = sessionFactory.getCurrentSession();//getting session from the sessionFactory
query = session.createQuery("FROM Books");
bookList = query.list();

} catch (NullPointerException npex) {
System.err.println("Can not perform " + npex.getMessage());
}

return bookList;

}

//This method sets the properties of the backing bean class
public void setBean(Books book) {
bookBean.setTitle(book.getTitle());
bookBean.setId(String.valueOf(book.getId()));
bookBean.setAuthor(book.getAuthor());
bookBean.setIsbn(book.getIsbn());
bookBean.setPublisher(book.getPublisher());
bookBean.setCountry(book.getCountry());
bookBean.setSex(book.getSex());

}

//Update detatils of book on Db
public void updateBook(int id) {
session = sessionFactory.getCurrentSession();
query = session.createQuery("UPDATE Books b SET b.title=:title, b.author=:author, b.isbn=:isbn, b.publisher=:publisher, b.country=:country, b.sex=:sex      WHERE b.id=:id");
query.setParameter("title",bookBean.getTitle());
query.setParameter("author",bookBean.getAuthor());
query.setParameter("isbn", bookBean.getIsbn());
query.setParameter("publisher",bookBean.getPublisher());
query.setParameter("country",bookBean.getCountry());
query.setParameter("sex",bookBean.getSex());




query.setParameter("id", id);
query.executeUpdate();
}

//Search the Db using bookId
public Books findById(int id) {
session = sessionFactory.getCurrentSession();
book = (Books) session.createQuery("FROM Books b where b.id=:id")
.setParameter("id", id)
.uniqueResult();
if (book != null) {
setBean(book);
}
return book;
}

//Delete a book from Db
public void deleteBook(int id) {
session = sessionFactory.getCurrentSession();
session.delete(session.load(Books.class, id));


}


//Search the Db using name
public Books findByName(String country) {
session = sessionFactory.getCurrentSession();
book = (Books) session.createQuery("FROM Books b where b.country=:country")
.setParameter("country", country)
.uniqueResult();
if (book != null) {
setBean(book);
}
return book;
}

}
