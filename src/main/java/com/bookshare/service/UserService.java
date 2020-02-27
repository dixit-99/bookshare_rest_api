package com.bookshare.service;

import java.util.List;

import com.bookshare.VO.User;
import com.bookshare.VO.Wishlist;

public interface UserService {

		long login(String email, String password);
		
		void addUser(User user);
		
		List getUser(long userId);
		
		void addWishlist(Wishlist wishlist);
		
		void rmWishlist(Wishlist wishlist);

}
