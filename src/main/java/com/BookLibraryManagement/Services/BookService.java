package com.BookLibraryManagement.Services;

import com.BookLibraryManagement.Entities.Book;
import com.BookLibraryManagement.Entities.User;
import com.BookLibraryManagement.Repositories.BookRepository;
import com.BookLibraryManagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> allbooks() {
        return bookRepository.findAll();
    }

    public Book bookFindById(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public Book borrowedBook(Long bookId, Long userId) {
        Book book = bookFindById(bookId);
        User user = userRepository.findById(userId).orElse(null);

        if(book != null && !book.isBorrowed() && user !=null ) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return addBook(book);
        }
        return null;
    }

    public Book returnBook(Long bookId) {
        Book book = bookFindById(bookId);

        if(book != null && book.isBorrowed()){
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return addBook(book);
        }
        return null;
    }



}
