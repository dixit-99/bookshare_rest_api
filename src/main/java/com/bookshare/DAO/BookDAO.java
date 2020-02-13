package com.bookshare.DAO;

import java.util.List;

import com.bookshare.VO.Book;

public interface BookDAO {

	void addBook(Book book);
	
	List getAllBooks();
	
}
