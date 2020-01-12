package com.bookshare.VO;

import javax.persistence.Embeddable;

@Embeddable
public class Wishlist {

		private long bookId;

		public long getBookId() {
			return bookId;
		}

		public void setBookId(long bookId) {
			this.bookId = bookId;
		}
}
