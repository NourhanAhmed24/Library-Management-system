package com.nourhancodes.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.nourhancodes.Model.Book;
import com.nourhancodes.Repository.BookRepo;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class bookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(String id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Book updateBook(String id, Book updatedBook) {
        updatedBook.setId(id);
        return bookRepo.save(updatedBook);
    }

    public void deleteBook(String id) {
        bookRepo.deleteById(id);
    }

    public Optional<Book> getBookByTitle(String title) {
        // TODO Auto-generated method stub
        return bookRepo.findByTitle(title);
    }
}
