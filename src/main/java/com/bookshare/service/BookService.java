package com.bookshare.service;

import java.util.List;

import com.bookshare.VO.Book;

public interface BookService {

	void addBook(Book book);
	
	List getAllBooks();
	
	List<Book> getBookDetails(Book book);
	
}
