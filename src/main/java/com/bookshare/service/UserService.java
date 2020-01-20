package com.bookshare.service;

import java.util.List;

import com.bookshare.VO.User;

public interface UserService {

		long login(String email, String password);
		
		void addUser(User user);
		
		List getUser(long userId);
		
		User editUser(long userId);
}
