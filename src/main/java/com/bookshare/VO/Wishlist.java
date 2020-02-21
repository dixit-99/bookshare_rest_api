package com.bookshare.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Wishlist")
public class Wishlist {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int wishlistId;
	
	  @ManyToOne
	  @JoinColumn(name = "userId")
	  private User user;
	
	  @ManyToOne
	  @JoinColumn(name = "bookId")
	  private Book book;
	
	  public int getWishlistId() {
	    return wishlistId;
	  }
	
	  public void setWishlistId(int wishlistId) {
	    this.wishlistId = wishlistId;
	  }
	
	  public Book getBook() {
	    return book;
	  }
	
	  public void setBook(Book book) {
	    this.book = book;
	  }
	
	  public User getUser() {
	    return user;
	  }
	
	  public void setUser(User user) {
	    this.user = user;
	  }
}