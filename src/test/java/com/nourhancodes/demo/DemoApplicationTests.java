package com.nourhancodes.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nourhancodes.Model.Book;
import com.nourhancodes.Model.Patron;
import com.nourhancodes.Repository.BookRepo;
import com.nourhancodes.Repository.PatronRepo;
import com.nourhancodes.Services.bookService;
import com.nourhancodes.Services.patronService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private bookService bookService;


	@MockBean
	private BookRepo bookRepo;

	@Autowired
	private patronService patronService;

	@MockBean
	private PatronRepo patronRepo;

	@Test
	public void getAllBooksTest()
	{
		when(bookRepo.findAll()).thenReturn(Stream.of(new Book("The Great Gatsby","F. Scott Fitzgerald",1925,"9780743273565"), new Book("To Kill a Mockingbird","Harper Lee",1960,"9780061120084")).collect(Collectors.toList()));
		assertEquals(2, bookService.getAllBooks().size());
	}

	@Test
	public void getBookByTitleTest() {
			String title = "The Great Gatsby";
			Book book = new Book("1", title, "F. Scott Fitzgerald", 1925, "9780743273565");
			when(bookRepo.findByTitle(title)).thenReturn(Optional.of(book));
			
			Optional<Book> result = bookService.getBookByTitle(title);
			assertEquals(Optional.of(book), result);
	}

	@Test
	public void getBookByIdTest() {
			String id = "1";
			Book book = new Book(id,"The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565");
			when(bookRepo.findById(id)).thenReturn(Optional.of(book));
			
			Book result = bookService.getBookById(id);
			assertEquals(book, result);
	}

	@Test
	public void addBookTest() {
    Book book = new Book("1", "The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565");
    when(bookRepo.save(book)).thenReturn(book);

    Book result = bookService.addBook(book);

    assertNotNull(result);
    assertEquals("The Great Gatsby", result.getTitle());
    verify(bookRepo, times(1)).save(book);
}


@Test
public void updateBookTest() {
    String id = "1";
    Book updatedBook = new Book(id, "The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565");
    when(bookRepo.save(updatedBook)).thenReturn(updatedBook);

    Book result = bookService.updateBook(id, updatedBook);

    assertNotNull(result);
    assertEquals(id, result.getId());
    assertEquals("The Great Gatsby", result.getTitle());
    verify(bookRepo, times(1)).save(updatedBook);
}


@Test
public void deleteBookTest() {
    String id = "1";

    // No need to return anything for delete operation
    doNothing().when(bookRepo).deleteById(id);

    bookService.deleteBook(id);

    verify(bookRepo, times(1)).deleteById(id);
}

@Test
	public void getAllPatronsTest()
	{
		when(patronRepo.findAll()).thenReturn(Stream.of(new Patron("nourhan","nourhan@gmail.com"), new Patron("shehab","shehab@gmail.com")).collect(Collectors.toList()));
		assertEquals(2, patronService.getAllPatrons().size());
	}

	@Test
	public void getPatronByIdTest() {
			String id = "1";
			Patron p = new Patron(id,"nourhan","nourhan@gmail.com");
			when(patronRepo.findById(id)).thenReturn(Optional.of(p));
			
		 Patron result = patronService.getPatronById(id);
			assertEquals(p, result);
	}

	@Test
	public void getPatronByNameTest() {
			String name = "nour";
			Patron p = new Patron(name,"nourhan@gmail.com");
			when(patronRepo.findByName(name)).thenReturn(Optional.of(p));
			
		  Patron result = patronService.getPatronByName(name);
			assertEquals(p, result);
	}


	@Test
	public void addPatronTest() {
    Patron p = new Patron("nour","nourhan@gmail.com");
    when(patronRepo.save(p)).thenReturn(p);

    Patron result = patronService.addPatron(p);

    assertNotNull(result);
    assertEquals("nour", result.getName());
    verify(patronRepo, times(1)).save(p);
}



@Test
public void updatePatronTest() {
    String name = "nour";
    Patron p = new Patron(name,"nourhan@gmail.com");
    when(patronRepo.save(p)).thenReturn(p);

    Patron result = patronService.updatePatron(name, p);

    assertNotNull(result);
    assertEquals(name, result.getName());
    
    verify(patronRepo, times(1)).save(p);
}


@Test
public void deletePatronTest() {
    String id = "1";

    // No need to return anything for delete operation
    doNothing().when(patronRepo).deleteById(id);

    patronService.deletePatron(id);

    verify(patronRepo, times(1)).deleteById(id);
}

}
