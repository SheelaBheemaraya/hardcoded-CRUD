package com.api.book.restbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.restbook.entity.Book;
import com.api.book.restbook.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/book")
	public List<Book> getBooks()
	{
//	    Book book=new Book();
//		 book.setId(1);
//		 book.setTitle("learn java");
//		 book.setAuthor("Sheela");
//		 return book;
		return bookservice.getAllBooks();
		
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id)

	{
		return bookservice.getBookById(id);
		
	}
	
	@PostMapping("/book")
    public Book addBook(@RequestBody Book book)
    {
		Book b=this.bookservice.addBook(book);
		return b;
    }
	// delete book handler

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
       
              this.bookservice.deleteBook(bookId);
			
    }
 // update book handler
    @PutMapping("/books/{bookId}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		this.bookservice.updateBook(book, bookId);
		return book;

}
}

