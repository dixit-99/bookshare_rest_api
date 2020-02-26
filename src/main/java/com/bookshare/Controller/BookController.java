package com.bookshare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookshare.VO.Book;
import com.bookshare.service.BookService;

@RestController
public class BookController {	
	
		@Autowired
		private BookService bookService;
		
		@CrossOrigin
		@PostMapping(value = "/addBook")
		@ResponseBody
		private ResponseEntity<Object> addUser(@RequestBody Book book) {
			
			System.out.println(book.toString());
			this.bookService.addBook(book);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		
		@CrossOrigin
		@GetMapping(value = "/getAllBooks")
		@ResponseBody
		private ResponseEntity<Object> getAllBooks() {
			
			List allBooks = this.bookService.getAllBooks();
			return new ResponseEntity<Object>(allBooks,HttpStatus.OK);
		}
		
		@CrossOrigin
		@GetMapping(value = "/getBook/{bookId}")
		public ResponseEntity<Object> getBookDetails(@PathVariable int bookId, @ModelAttribute Book book) {
		    List<Book> bookDetails = this.bookService.getBookDetails(book);
		    return new ResponseEntity<Object>(bookDetails, HttpStatus.OK);
		}
		
		@CrossOrigin
		@GetMapping(value = "/subject/{semester}/{branchId}")
		public ResponseEntity<Object> getBookDetails(@PathVariable String semester,@PathVariable int branchId) {
			System.out.println("andar aayu");
		    List subjects = this.bookService.getSubjects(semester, branchId);
		    System.out.println(subjects);
		    return new ResponseEntity<Object>(subjects, HttpStatus.OK);
		}
}
