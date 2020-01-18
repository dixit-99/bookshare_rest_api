package com.bookshare.VO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_Generator")
		@SequenceGenerator(name = "order_Generator",initialValue = 200000, allocationSize = 1,sequenceName = "order_Sequence")
		private long orderId;
		
		private long sellerId;
		
		private long bookId;
		
		//buyerId
		@ManyToOne
		private User user;

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

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		
}
