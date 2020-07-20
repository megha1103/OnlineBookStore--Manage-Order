package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.exceptions.BookIdNotFoundException;
import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.entities.CartInformation;
import com.cg.bookStore.entities.CustomerReview;
import com.cg.bookStore.exceptions.BookIdException;
import com.cg.bookStore.exceptions.OrdersException;

public interface BookService {
	public OrderInformation viewOrderDetails(int orderId)throws OrdersException;
	


	public boolean removeBook(String bookId)throws BookIdException,BookIdNotFoundException;
	
	

	//cancle Order.
	public boolean findOrderById(int orderId);
	public String cancleOrder(int orderId);
	
	//list order
	public List<OrderInformation> showOrderList();
}
 
