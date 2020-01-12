package com.bookshare.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookshare.VO.User;

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
		public boolean logn(String email, String password) {
			try {
				Session session = sessionFactory.getCurrentSession();
				Query q = session.createQuery("from User where email = '"+email+"' and password = '"+password+"'");
				List ls = q.list();
				if(ls.isEmpty())
					return false;
				else
					return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		
}