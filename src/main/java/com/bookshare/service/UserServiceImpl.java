package com.bookshare.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshare.DAO.UserDAO;
import com.bookshare.VO.User;
import com.bookshare.VO.Wishlist;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void addUser(User user) {
		this.userDAO.addUser(user);
	}

	@Override
	public long login(String email, String password) {
		return userDAO.login(email, password);
	}
	
	@Override
	public List getUser(long userId) {
		return this.userDAO.getUser(userId);
	}
	
	@Override
	public void addWishlist(Wishlist wishlist) {
	    this.userDAO.addWishlist(wishlist);
	}

}
