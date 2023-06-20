package webapp.my.webappdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webapp.my.webappdemo.model.Book;
import webapp.my.webappdemo.service.BookService;

import java.util.Collection;

@RestController
@RequestMapping("books")
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("{id}") // GET http://localhost:8080/books/1
    public ResponseEntity<Book> getBookInfo(@PathVariable int id){
        Book book = bookService.getBook(id);
        if (book == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }
    @GetMapping
    public ResponseEntity<Collection<Book>> getAllBooks (){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @PostMapping // POST http://localhost:8080/books
    public Book createBook (@RequestBody Book book){
        return bookService.createBook(book);
    }
    @PutMapping // PUT http://localhost:8080/books
    public ResponseEntity<Book> editBook (@RequestBody Book book){
        Book foundbook = bookService.editBook(book);
        if (foundbook == null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundbook);
    }
    @DeleteMapping("{id}") // DELETE http://localhost:8080/books/1
    public Book editBook (@PathVariable int id){
        return bookService.deleteBook(id);
    }
}
