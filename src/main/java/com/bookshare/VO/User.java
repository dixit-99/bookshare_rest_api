package com.bookshare.VO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "userGenerator")
		@SequenceGenerator(name = "userGenerator",initialValue = 100000, allocationSize = 1,sequenceName = "userSequence")
		private long userId;
		
		@Column(name = "passwrod",nullable = false,length = 8)
		private String password;
		
		@Column(name = "firstName",nullable = false,length = 20)
		private String firstName;
		
		@Column(name = "lastName",nullable = false,length = 20)
		private String lastName;
		
		@Column(name = "userType",nullable = false,length = 10)
		private String userType;
		
		@Column(name = "email",nullable = false,length = 30,unique = true)
		private String email;
		
		@Column(name = "wpno",nullable = false,length = 10)
		private String wpno;
		
		@Column(name = "college",nullable = false,length = 100)
		private String college;
		
		@ElementCollection(fetch = FetchType.EAGER)
		private Set<Wishlist> wishlist =  new HashSet<Wishlist>();
		
		@ElementCollection
		private Set<Order> order = new HashSet<Order>();

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getWpno() {
			return wpno;
		}

		public void setWpno(String wpno) {
			this.wpno = wpno;
		}

		public String getCollege() {
			return college;
		}

		public void setCollege(String college) {
			this.college = college;
		}

		public Set<Wishlist> getWishlist() {
			return wishlist;
		}

		public void setWishlist(Set<Wishlist> wishlist) {
			this.wishlist = wishlist;
		}

		public Set<Order> getOrder() {
			return order;
		}

		public void setOrder(Set<Order> order) {
			this.order = order;
		}
}
