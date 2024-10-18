package com.BookLibraryManagement.Controllers;

import com.BookLibraryManagement.Entities.Book;
import com.BookLibraryManagement.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return bookService.allbooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.bookFindById(bookId);
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
         bookService.deleteBook(bookId);
    }

    @PostMapping("/{bookId}/borrowed/{userId}")
    public ResponseEntity<Book> borrowedBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowedBook = bookService.borrowedBook(bookId, userId);
        if(borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
        Book returnBook = bookService.returnBook(bookId);
        if(returnBook != null) {
            return ResponseEntity.ok(returnBook);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}
