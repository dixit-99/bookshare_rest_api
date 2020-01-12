package com.bookshare.DAO;

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
}