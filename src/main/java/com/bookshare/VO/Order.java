package com.bookshare.VO;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Embeddable
public class Order {
	
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "orderGenerator")
		@SequenceGenerator(name = "orderGenerator",initialValue = 200000, allocationSize = 1,sequenceName = "orderSequence")
		private long orderId;
		
		private long sellerId;
		
		private long bookId;

		public long getOrderId() {
			return orderId;
		}

		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}

		public long getSellerId() {
			return sellerId;
		}

		public void setSellerId(long sellerId) {
			this.sellerId = sellerId;
		}

		public long getBookId() {
			return bookId;
		}

		public void setBookId(long bookId) {
			this.bookId = bookId;
		}
}
