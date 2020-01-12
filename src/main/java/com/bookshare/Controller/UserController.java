package com.bookshare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookshare.VO.User;
import com.bookshare.service.UserService;

@RestController
public class UserController {

		@Autowired
		private UserService userService;
		
		@CrossOrigin
		@GetMapping(value = "/login/{email}/{password}")
		@ResponseBody
		private ResponseEntity<Object> login(@PathVariable("email") String email,@PathVariable("password") String password) {
			System.out.println(email+ " "+password);
			boolean b = userService.logn(email, password);
			System.out.println(b);
			return new ResponseEntity<Object>(b,HttpStatus.OK);
		}
		
		@CrossOrigin
		@PostMapping(value = "/addUser")
		@ResponseBody
		private ResponseEntity<Object> addUser(@RequestBody User user) {
			this.userService.addUser(user);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		
		
}
