package com.bookshare.DAO;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookshare.VO.Book;
import com.bookshare.VO.DTO.AllBooks;

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

		@Override
		public List getAllBooks() {
			try {
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createSQLQuery("select bookId, bookName, semester, subjectName, author, publication, originalPrice, sellingPrice, discount, seen, imageLinkFront from Book");
				query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
				query.setFirstResult(0);
				query.setMaxResults(1);
				
				List<Map<String,Object>> allBooks = query.list();
				return allBooks;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

}
