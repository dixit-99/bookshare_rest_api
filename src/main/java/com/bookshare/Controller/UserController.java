package com.bookshare.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.spi.LoggerFactory;
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
import org.springframework.web.multipart.MultipartFile;

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
			User u = this.userService.getUser(userId);
			return new ResponseEntity<Object>(u,HttpStatus.OK);
		}
		
	  @CrossOrigin
	  @PostMapping("/upload")
	  public boolean pictureupload(@RequestParam("file") MultipartFile file) {

			String fileName = file.getOriginalFilename();
			
			try {
				byte b[] = file.getBytes();
				
				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("D:\\"+fileName));
				
				bout.write(b);  
		        bout.flush();  
		        bout.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return true;
	  }
}
