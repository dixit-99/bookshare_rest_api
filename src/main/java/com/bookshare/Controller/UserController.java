package com.bookshare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookshare.VO.Book;
import com.bookshare.VO.User;
import com.bookshare.VO.Wishlist;
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
			long b = userService.login(email, password);
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
		
		@CrossOrigin
		@GetMapping(value = "/profile/{userId}")
		@ResponseBody
		private ResponseEntity<Object> getUser(@PathVariable("userId") long userId) {
			List ls = this.userService.getUser(userId);
			return new ResponseEntity<Object>(ls,HttpStatus.OK);
		}
		
		@CrossOrigin
		@GetMapping(value = "/edit/{userId}")
		@ResponseBody
		private ResponseEntity<Object> editUser(@PathVariable("userId") long userId) {
			User user = (User)this.userService.getUser(userId).get(0);
			return new ResponseEntity<Object>(user,HttpStatus.OK);
		}
		
		@CrossOrigin
		@PostMapping(value = "/addWishlist/{userId}/{bookId}")
		public ResponseEntity<Object> addWishlist(@PathVariable int userId, @PathVariable int bookId, @ModelAttribute User user,@ModelAttribute Book book) {
			Wishlist wishlist = new Wishlist();
			wishlist.setUser(user);
			book.setBookId(bookId);
			wishlist.setBook(book);
			
			
			this.userService.addWishlist(wishlist);
			long wishlistId = wishlist.getWishlistId();
			return new ResponseEntity<Object>(wishlistId,HttpStatus.OK);
		}
		
		@CrossOrigin
		@DeleteMapping(value = "/rmWishlist/{wishlistId}")
		public ResponseEntity<Object> removeWihlist(@PathVariable int wishlistId,@ModelAttribute Wishlist wishlist){
			wishlist.setWishlistId(wishlistId);
		    this.userService.rmWishlist(wishlist);
		    return new ResponseEntity<Object>(HttpStatus.OK);    
		}
		
		@CrossOrigin
		@GetMapping(value = "/getWishlist/{userId}")
		public ResponseEntity<Object> getWishlist(@PathVariable int userId,@ModelAttribute User user)
		{
			user.setUserId(userId);
			List wishlist=this.userService.getWishlist(user);
			return new ResponseEntity<Object>(wishlist,HttpStatus.OK);
		}
		
}
