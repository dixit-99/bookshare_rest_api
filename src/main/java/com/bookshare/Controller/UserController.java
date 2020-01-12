package com.bookshare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookshare.VO.User;
import com.bookshare.service.UserService;

@RestController
public class UserController {

		@Autowired
		private UserService userService;
		
		@CrossOrigin
		@PostMapping(value = "/addUser")
		@ResponseBody
		private ResponseEntity<Object> addUser(@RequestBody User user) {
			this.userService.addUser(user);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		
		
}
