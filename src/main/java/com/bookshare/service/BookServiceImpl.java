package com.bookshare.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshare.DAO.BookDAO;
import com.bookshare.VO.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public void addBook(Book book) {
		this.bookDAO.addBook(book);
	}

	@Override
	public List getAllBooks() {
		return bookDAO.getAllBooks();
	}
	
	@Override
	public List<Book> getBookDetails(Book book) {
	    return this.bookDAO.getBookDetails(book);
	}

}
