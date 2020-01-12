package com.bookshare.service;

import com.bookshare.VO.User;

public interface UserService {

	boolean logn(String email, String password);
	
	void addUser(User user);
}
