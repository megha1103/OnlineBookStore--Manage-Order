package com.cg.bookStore.web;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.cg.bookStore.exceptions.BookIdNotFoundException;
import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.entities.CartInformation;
import com.cg.bookStore.entities.CustomerReview;
import com.cg.bookStore.exceptions.BookIdException;
import com.cg.bookStore.exceptions.OrdersException;
import com.cg.bookStore.service.BookService;
import org.springframework.http.HttpStatus;


@RestController
public class OrdersRestController {

	@Autowired
	public BookService service;

	@GetMapping("/viewOrderDetailsById")
	public OrderInformation viewOrderDetails(@RequestParam int orderId) throws OrdersException {

		return service.viewOrderDetails(orderId);	
	
	}
	
	
	

	@DeleteMapping("/deletebook/{bookId}")
	public String deleteBook(@PathVariable("bookId")String bookId)throws BookIdException,
	BookIdNotFoundException{
		
	    	service.removeBook(bookId);
	     	return "Successfully Deleted";
		
}
	
	
	//Cancle Order
	
		@GetMapping("/CancleOrder/{orderId}")
		public ResponseEntity<String> DepositSlip(@PathVariable int orderId)  {
			String result="Order Id Not Found";
			if(service.findOrderById(orderId))
			{
				
				result=service.cancleOrder(orderId);
				return new ResponseEntity<String>(result,HttpStatus.OK);
				 
			}
			else
				return new ResponseEntity<String>(result,HttpStatus.OK);
			
			
		}
		
		//List Order
		
		public ResponseEntity<List<OrderInformation>> showOrder()
		{
			// add Exception 
			return new ResponseEntity<List<OrderInformation>>(service.showOrderList(),HttpStatus.OK);
			
		}
}
