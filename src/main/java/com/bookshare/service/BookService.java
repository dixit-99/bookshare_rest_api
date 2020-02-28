package com.bookshare.service;

import java.util.List;

import com.bookshare.VO.Book;
import com.bookshare.VO.Branch;
import com.bookshare.VO.Subject;
import com.bookshare.VO.User;

public interface BookService {

	void addBook(Book book);
	
	List getAllBooks();
	
	List<Book> getBookDetails(Book book);
	
	List<Subject> getSubjects(String semester, int branchId);
	
	List filter(Branch branch, Subject subject);
	
	List filter(Branch branch, Subject subject,User user);
	
	List filterBySemBranch(Branch branch, Subject subject);
	
}
