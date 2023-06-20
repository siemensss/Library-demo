package webapp.my.webappdemo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import webapp.my.webappdemo.model.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {
    private Map<Integer, Book> books = new HashMap<>();
    private Integer lastId = 0;
    public Book createBook (Book book){
        book.setId(++lastId);
        books.put(lastId, book);
        return book;
    }
    public Book getBook (int id){
        return books.get(id);
    }
    public Book editBook(Book book){
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
            return book;
        }
        return null;
    }
    public Book deleteBook(int id){
        return books.remove(id);
    }

    public Collection<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
}
