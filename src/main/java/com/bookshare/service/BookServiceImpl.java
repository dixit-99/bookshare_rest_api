package com.bookshare.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshare.DAO.BookDAO;
import com.bookshare.VO.Book;
import com.bookshare.VO.Branch;
import com.bookshare.VO.Subject;
import com.bookshare.VO.User;

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

	@Override
	public List<Subject> getSubjects(String semester, int branchId) {
		return bookDAO.getSubjects(semester, branchId);
	}
	
	@Override
	public List filter(Branch branch, Subject subject) {
	    return this.bookDAO.filter(branch, subject);
	}
	
	@Override
	  public List filter(Branch branch, Subject subject,User user) {
	    return this.bookDAO.filter(branch, subject,user);
	  }
	
	@Override
	  public List filterBySemBranch(Branch branch, Subject subject) {
	    return this.bookDAO.filterBySemBranch(branch, subject);
	  }

}
