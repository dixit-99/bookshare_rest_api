package com.bookshare.service;

import java.util.List;

import com.bookshare.VO.Book;
import com.bookshare.VO.Subject;

public interface BookService {

	void addBook(Book book);
	
	List getAllBooks();
	
	List<Book> getBookDetails(Book book);
	
	List<Subject> getSubjects(String semester, int branchId);
	
}
