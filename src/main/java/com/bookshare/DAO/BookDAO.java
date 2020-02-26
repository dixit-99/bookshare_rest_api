package com.bookshare.DAO;

import java.util.List;

import com.bookshare.VO.Book;
import com.bookshare.VO.Subject;

public interface BookDAO {

	void addBook(Book book);
	
	List getAllBooks();
	
	List<Book> getBookDetails(Book book);
	
	List<Subject> getSubjects(String semester, int branchId);
}
