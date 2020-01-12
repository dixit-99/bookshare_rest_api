package com.bookshare.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshare.DAO.UserDAO;
import com.bookshare.VO.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void addUser(User user) {
		this.userDAO.addUser(user);
	}
}
