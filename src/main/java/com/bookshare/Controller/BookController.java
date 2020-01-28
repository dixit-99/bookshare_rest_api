package com.bookshare.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bookshare.VO.Book;
import com.bookshare.service.BookService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@RestController
public class BookController {	
	
		@Autowired
		private BookService bookService;
		
		@CrossOrigin
		@PostMapping(value = "/addBook")
		@ResponseBody
		private ResponseEntity<Object> addUser(@RequestBody Book book) {
			this.bookService.addBook(book);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		
		@CrossOrigin
		@PostMapping(value = "/upload")
		@ResponseBody
		private ResponseEntity<Object> upload(@RequestParam("fileFront") MultipartFile fileFront,@RequestParam("fileBack") MultipartFile fileBack) {
			
			try {
			
				Map config = new HashMap();
				config.put("cloud_name", "bookshare123");
				config.put("api_key", "826311686619931");
				config.put("api_secret", "HiON8Lb6uoU5mb4gYZTYGFTNjdo");
				Cloudinary cloudinary = new Cloudinary(config);
				
				Map uploadResultFront = cloudinary.uploader().upload(fileFront.getBytes(), ObjectUtils.emptyMap());
				Map uploadResultBack = cloudinary.uploader().upload(fileBack.getBytes(), ObjectUtils.emptyMap());
				
				String imgurlFront = (String) uploadResultFront.get("url");
				System.out.println(imgurlFront);
				
				String imgurlBack = (String) uploadResultBack.get("url");
				System.out.println(imgurlBack);
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return new ResponseEntity<Object>(HttpStatus.OK);
		}

}
