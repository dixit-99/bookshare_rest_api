package com.bookshare.DAO;

import com.bookshare.VO.User;

public interface UserDAO {
	
		boolean logn(String email, String password);
		
		void addUser(User user);
}
