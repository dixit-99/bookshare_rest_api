package com.bookshare.VO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "Wishlist")
public class Wishlist {
	
		@Id
		private long userId;
	
		@ElementCollection
		@JoinTable(name = "Wishcart")
		private Set<Wishcart> wishcart = new HashSet<Wishcart>();

}
