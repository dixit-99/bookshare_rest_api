package com.bookshare.VO;

import javax.persistence.Embeddable;

@Embeddable
public class Wishcart {
	
		private long bookId;

		public long getBookId() {
			return bookId;
		}

		public void setBookId(long bookId) {
			this.bookId = bookId;
		}
		
}
