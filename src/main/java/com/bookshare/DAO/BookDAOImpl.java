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
import com.bookshare.VO.Branch;
import com.bookshare.VO.Subject;
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
				Query query = session.createSQLQuery("select bookId, bookName, semester, subjectName, author, publication, originalPrice, sellingPrice, discount, seen, imageLinkFront from Book where status='true'");
				query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
				query.setFirstResult(0);
//				query.setMaxResults(5);
				
				List<Map<String,Object>> allBooks = query.list();
				return allBooks;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
	    public List<Book> getBookDetails(Book book) {
	      
	      Session session = sessionFactory.getCurrentSession();
	      Query query = session.createQuery("from Book where bookId = "+book.getBookId());

	      List<Book> bookDetails = query.list();  
	      return bookDetails;
	    }
		
		@Override
		public List getSubjects(String semester, int branchId) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("select subjectid,subjectname from subject where semester = '"+semester+"' and branch_branchid = "+branchId);
			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			List<Map<String,Object>> subjects = query.list();
			return subjects;
		}
		
		@Override
		public List filter(Branch branch, Subject subject) {
		    Session session = sessionFactory.getCurrentSession();
		    Query query = session.createSQLQuery("select bookid, bookname, imagelinkfront, sellingprice, originalprice, discount, subjectname, author, publication, semester, seen from book where subjectcode = any(select subjectCode from subject where subjectId = "+subject.getSubjectId()+" and branch_branchId = "+branch.getBranchId()+" and semester = '"+subject.getSemester()+"')");
		    query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
		    List<Map<String,Object>> subjects = query.list();
		    List booksByFilter = query.list();
		    return booksByFilter;
		  }

}
