package com.bookshare.service;

import com.bookshare.VO.User;

public interface UserService {

	long login(String email, String password);
	
	void addUser(User user);
}
