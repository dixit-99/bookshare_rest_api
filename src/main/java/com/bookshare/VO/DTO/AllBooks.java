package com.bookshare.VO.DTO;

public class AllBooks {
	
		private long bookId;
		private String bookName;
		private String semester;
		private String subjectName;
		private String author;
		private String publication;
		private int originalPrice;
		private int sellingPrice;
		private String discount;
		private String imageLinkFront;
		private String seen;
		
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
		public String getImageLinkFront() {
			return imageLinkFront;
		}
		public void setImageLinkFront(String imageLinkFront) {
			this.imageLinkFront = imageLinkFront;
		}
		public String getSeen() {
			return seen;
		}
		public void setSeen(String seen) {
			this.seen = seen;
		}
		
		@Override
		public String toString() {
			return "AllBooks [bookId=" + bookId + ", bookName=" + bookName + ", semester=" + semester + ", subjectName="
					+ subjectName + ", author=" + author + ", publication=" + publication + ", originalPrice="
					+ originalPrice + ", sellingPrice=" + sellingPrice + ", discount=" + discount + ", imageLinkFront="
					+ imageLinkFront + ", seen=" + seen + "]";
		}
		
}
