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
import com.bookshare.VO.Branch;
import com.bookshare.VO.Subject;
import com.bookshare.VO.User;
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
		    List subjects = this.bookService.getSubjects(semester, branchId);
		    return new ResponseEntity<Object>(subjects, HttpStatus.OK);
		}
		
		@CrossOrigin
		@GetMapping(value = "/filter/{semester}/{branchId}/{subjectId}")
		public ResponseEntity<Object> filter(@PathVariable String semester, @PathVariable int subjectId, @PathVariable int branchId,@ModelAttribute Branch branch, @ModelAttribute Book book,@ModelAttribute Subject subject) {
			branch.setBranchId(branchId);
			subject.setSubjectId(subjectId);
			subject.setSemester(semester);
			List filterBooks = this.bookService.filter(branch, subject);
			System.out.println(filterBooks);
			return new ResponseEntity<Object>(filterBooks,HttpStatus.OK);
		}
		
		@CrossOrigin
		@GetMapping(value = "/filterCollege/{sem}/{branchId}/{subjectId}/{college}")
		  public ResponseEntity<Object> filter(@PathVariable String sem, @PathVariable int subjectId,
		      @PathVariable int branchId, @PathVariable String college, @ModelAttribute User user,
		      @ModelAttribute Branch branch, @ModelAttribute Book book, @ModelAttribute Subject subject) {

		    branch.setBranchId(branchId);
		    subject.setSubjectId(subjectId);
		    subject.setSemester(sem);
		    System.out.println(college);

		    user.setCollege(college);
		    List booksByFilter = this.bookService.filter(branch, subject, user);
		    return new ResponseEntity<Object>(booksByFilter, HttpStatus.OK);
		  }
		
		@CrossOrigin
		@GetMapping(value = "/filter2/{sem}/{branchId}")
		  public ResponseEntity<Object> filterBySemBranch(@PathVariable String sem, @PathVariable int branchId, 
		      @ModelAttribute Subject subject, @ModelAttribute Branch branch){
		    branch.setBranchId(branchId);
		    subject.setSemester(sem);
		    List booksByFilter = this.bookService.filterBySemBranch(branch, subject);
		    return new ResponseEntity<Object>(booksByFilter, HttpStatus.OK);
		  }
}