package com.cg.bookStore.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.entities.CartInformation;
import com.cg.bookStore.entities.CustomerReview;


@Repository
public class BookDaoImpl implements BookDao{

	@PersistenceContext
	private EntityManager em;
		
	
	@Override
	public OrderInformation viewOrderDetails(int orderId) {
		return em.find(OrderInformation.class,orderId);
	}
	

	public boolean removeBook(int bookId) {
	    String jpql ="delete from OrderInformation p where p.book.bookId=:bid";
			
			Query query = em.createQuery(jpql);
			
			query.setParameter("bid", bookId);
			int res =query.executeUpdate();
			if(res > 0)
			return true;
			else
				return false;
			
		}

		

	//Cancle Order.
			@Override
			public boolean findOrder(int orderId) {
				// TODO Auto-generated method stub
				return em.contains(em.find(OrderInformation.class, orderId));
				
			}



			@Override
			public void updateOrderStatus(int orderId, String orderStatus) {
				// TODO Auto-generated method stub
				em.find(OrderInformation.class, orderId).setOrderStatus(orderStatus);
			}


			@Override
			public OrderInformation getOrderDetails(int orderId) {
				// TODO Auto-generated method stub
				return em.find(OrderInformation.class, orderId);
			}
	//List of all Order


			@Override
			public List<OrderInformation> showListOrder() {
				// TODO Auto-generated method stub
				Query query=em.createQuery("select * from OrderInformation order");
				return query.getResultList();
			}
			
			

	}








		







