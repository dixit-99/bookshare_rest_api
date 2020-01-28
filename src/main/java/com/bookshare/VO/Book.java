package com.bookshare.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_Generator")
		@SequenceGenerator(name = "book_Generator",initialValue = 300000, allocationSize = 1,sequenceName = "book_Sequence")
		private long bookId;
		
		@Column(name = "bookName",nullable = false,length = 20)
		private String bookName;
		
		@Column(name = "branchName",nullable = false,length = 50)
		private String branchName;
		
		@Column(name = "semester",nullable = false,length = 1)
		private String semester;
		
		@Column(name = "subjectName",nullable = false,length = 10)
		private String subjectName;
		
		@Column(name="subjectCode",length = 7,nullable = false)
		private String subjectCode;
		
		@Column(name="author",length = 30,nullable = false)
		private String author;
		
		@Column(name="publication",length = 30,nullable = false)
		private String publication;
		
		@Column(name="edition",length = 3,nullable = false)
		private String edition;
		
		@Column(name="publishedYear",length = 4,nullable = false)
		private String publishedYear;
		
		@Column(name="page",length = 4,nullable = false)
		private String page;
		
		@Column(name="bookCondition",length = 10,nullable = false)
		private String bookCondition;
		
		@Column(name="originalPrice",length = 4,nullable = false)
		private int originalPrice;
		
		@Column(name="sellingPrice",nullable = false)
		private int sellingPrice;
		
		@Column(name="discount",length = 2,nullable = false)
		private String discount;
		
		@Column(name="imageLink",length = 200,nullable = false)
		private String imageLink = "http://img.com/img1";
		
		@Column(name = "seen",length = 4,nullable = false)
		private String seen = "0";
		
		@Column(name = "status",nullable = false)
		private boolean status = true;
		
		//seller Id
		@ManyToOne
		private User user;

		public long getBookId() {
			return bookId;
		}

		public void setBookId(long bookId) {
			this.bookId = bookId;
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getBranchName() {
			return branchName;
		}

		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}

		public String getSemester() {
			return semester;
		}

		public void setSemester(String semester) {
			this.semester = semester;
		}

		public String getSubjectName() {
			return subjectName;
		}

		public void setSubjectName(String subjectName) {
			this.subjectName = subjectName;
		}

		public String getSubjectCode() {
			return subjectCode;
		}

		public void setSubjectCode(String subjectCode) {
			this.subjectCode = subjectCode;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPublication() {
			return publication;
		}

		public void setPublication(String publication) {
			this.publication = publication;
		}

		public String getEdition() {
			return edition;
		}

		public void setEdition(String edition) {
			this.edition = edition;
		}

		public String getPublishedYear() {
			return publishedYear;
		}

		public void setPublishedYear(String publishedYear) {
			this.publishedYear = publishedYear;
		}

		public String getPage() {
			return page;
		}

		public void setPage(String page) {
			this.page = page;
		}

		public String getBookCondition() {
			return bookCondition;
		}

		public void setBookCondition(String bookCondition) {
			this.bookCondition = bookCondition;
		}

		public int getOriginalPrice() {
			return originalPrice;
		}

		public void setOriginalPrice(int originalPrice) {
			this.originalPrice = originalPrice;
		}

		public int getSellingPrice() {
			return sellingPrice;
		}

		public void setSellingPrice(int sellingPrice) {
			this.sellingPrice = sellingPrice;
		}

		public String getDiscount() {
			return discount;
		}

		public void setDiscount(String discount) {
			this.discount = discount;
		}

		public String getImageLink() {
			return imageLink;
		}

		public void setImageLink(String imageLink) {
			this.imageLink = imageLink;
		}

		public String getSeen() {
			return seen;
		}

		public void setSeen(String seen) {
			this.seen = seen;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
}
