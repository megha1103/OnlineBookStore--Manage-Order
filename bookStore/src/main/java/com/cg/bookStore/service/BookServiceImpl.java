package com.cg.bookStore.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.exceptions.BookIdNotFoundException;
import com.cg.bookStore.dao.BookDao;
import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.entities.CartInformation;
import com.cg.bookStore.entities.CustomerReview;
import com.cg.bookStore.exceptions.BookIdException;
import com.cg.bookStore.exceptions.OrdersException;
import com.cg.bookStore.util.OrderConstraints;



@Service("Orderser")
@Transactional
public class BookServiceImpl implements BookService{


	@Autowired
	private BookDao dao;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	
	@Override
	public OrderInformation viewOrderDetails(int orderId) throws OrdersException {
	
		OrderInformation order = dao.viewOrderDetails(orderId);
		if(order==null)
			throw new OrdersException(OrderConstraints.INVALID_ORDERID);
		return order;
	}
	
	

	@Transactional
 public boolean removeBook(String bookId) throws BookIdException, BookIdNotFoundException {

	if(!bookId.matches("^[0-9]*$"))
		throw new BookIdException(OrderConstraints.BOOK_Id_EXCEPTION);
	
	else if(dao.removeBook(Integer.parseInt(bookId))!=true)
		throw new BookIdNotFoundException(OrderConstraints.BOOK_ID_NOT_Found);
	 
	else
		 dao.removeBook(Integer.parseInt(bookId));
	    return true;
	}
	




	@Override
	public boolean findOrderById(int orderId) {
		// TODO Auto-generated method stub
		return dao.findOrder(orderId);
	}




	@Override
	public String cancleOrder(int orderId) {
		// TODO Auto-generated method stub
		OrderInformation orderDetails=new OrderInformation();
		orderDetails=dao.getOrderDetails(orderId);
		
		if(orderDetails.getOrderStatus().equals("Processing"))
		{
			dao.updateOrderStatus(orderId, "Cancelled");
			return "Order is Cancelled";
		}
		else if(orderDetails.getOrderStatus().equals("Cancelled"))
		{
			return "Order is already Cancelled";
		}
		else if(orderDetails.getOrderStatus().equals("Shipped"))
		{
			return "Cannot Cancelled Order, Order is already Shipped";
		}
		return null;
	}




	@Override
	public List<OrderInformation> showOrderList() {
		// TODO Auto-generated method stub
		return dao.showListOrder();
	}

	
	
	
}