package com.bookshare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
			this.bookService.addBook(book);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
}
