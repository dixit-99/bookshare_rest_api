package com.bookshare.DAO;

import com.bookshare.VO.User;

public interface UserDAO {
	
		long login(String email, String password);
		
		void addUser(User user);
		
		User getUser(long userId);
		
//		boolean addToWishlist(long userId,long bookId);
}
