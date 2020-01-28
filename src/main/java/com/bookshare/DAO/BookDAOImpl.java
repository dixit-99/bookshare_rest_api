package com.bookshare.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookshare.VO.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	
		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public void addBook(Book book) {
			try {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(book);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

}
