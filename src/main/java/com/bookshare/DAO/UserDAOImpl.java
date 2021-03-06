package com.bookshare.DAO;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookshare.VO.User;
import com.bookshare.VO.Wishlist;

@Repository
public class UserDAOImpl implements UserDAO {
	
		@Autowired
		private SessionFactory sessionFactory;
		
		@Override
		public void addUser(User user) {
			try {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(user);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public long login(String email, String password) {
			try {
				Session session = sessionFactory.getCurrentSession();
				Query q = session.createQuery("from User where email = '"+email+"' and password = '"+password+"'");
				List ls = q.list();
				if(ls.isEmpty())
					return 0;
				else
					return ((User)ls.get(0)).getUserId();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		@Override
		public List getUser(long userId) {
			try{
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("from User where userId = "+userId);
				List ls = query.list();
				return ls;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		public void addWishlist(Wishlist wishlist) {
			try {
		        Session session = sessionFactory.getCurrentSession();
		        session.saveOrUpdate(wishlist);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

		@Override
		public void rmWishlist(Wishlist wishlist) {
		    try {
		      Session session = sessionFactory.getCurrentSession();
		      session.delete(wishlist);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		}

		@Override
		public List getWishlist(User user) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("select b.bookId, b.bookName, imageLinkFront, sellingPrice, originalPrice, discount, wishlistId, subjectName, author, publication, semester, seen from book b , wishlist w where b.bookId = w.bookId and w.userId = "+ user.getUserId());
			query.setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
			List<Map<String,Object>>  getWishList = query.list();
			return getWishList;
		}
}
	