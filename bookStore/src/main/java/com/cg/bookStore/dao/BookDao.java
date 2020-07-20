package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entities.Admin;


import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.entities.CartInformation;
import com.cg.bookStore.entities.CustomerReview;


public interface BookDao {

	public OrderInformation viewOrderDetails(int orderId);
	
	public boolean removeBook(int bookId);
	
	//Cancle Order
		public boolean findOrder(int orderId);
		public OrderInformation getOrderDetails(int orderId);
		public void updateOrderStatus(int orderId,String orderStatus);
		
		//List all order
		public List<OrderInformation> showListOrder();
	
    
}
