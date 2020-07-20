package com.cg.bookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.bookStore.dao.BookDao;
import com.cg.bookStore.entities.BookCategory;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.service.BookServiceImpl;
import com.cg.bookStore.web.OrdersRestController;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class restControllerTesting {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	BookServiceImpl bookService;

	
int orderId=1;
	@Test
	public void viewOrderDetails() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/viewOrderDetailsById/?orderId=1");
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"orderId\":1,\"customerDetails\":{\"emailAddress\":\"hg@gmail.com\",\"fullName\":\"ghh\",\"password\":\"123qdse34\",\"phoneNumber\":\"1234567890\",\"city\":\"huhj\",\"zipCode\":654789,\"country\":\"gyuh\",\"registerDate\":\"2020-11-11\"},\"shippingAddress\":\"gghvb\",\"quantity\":15,\"subTotal\":2000.0,\"total\":8888.0,\"orderStatus\":\"shipped\",\"paymentMethod\":\"online\",\"orderDate\":null,\"book\":null}"))
				.andReturn();
	/*	
		int orderId=1;
		//String categoryJson = "{\"categoryName\":\"\"}";
			Mockito.when(
				bookService.viewOrderDetails(orderId))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageCategory/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Cannot add empty category")).andDo(MockMvcResultHandlers.print());
		//JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		 * 
		 * 
		 */
		
	}

}


	/*
	
	String categoryJson = "{\"title\":\"\","
			+ "\"author\":\"JK Rowling\","
			+ "\"description\":\"The primary argument supporting cell phone control in the classroom is the fact that phones can be distracting. Not only do cell phones distract instructors, but they may also distract students trying to pay attention to the lecture. This is the same effect as a moviegoer looking at his phone in a theater. Even if the phone makes no noise, the light from the screen is enough to catch someone’s attention.Arguments against cell phone control typically focus on safety concerns. Should a crisis occurs in the classroom, students should have their phones on hand to make a call. If a student has a child, he or she may need a phone in case of a medical emergency. If the student is on call for work, he or she will need access to a phone. The list of exception-worthy scenarios is endless.The best solution is to create cell phone usage rules that allow devices to be accessible without disturbing other students’ educational opportunities. Students should be permitted to keep their phones in their bags, pockets, or other belongings as lo\","
			+ "\"price\":\"200\","
			+ "\"isbnNumber\":\"123456789123\","
			+ "\"publishDate\":\"2020-03-12\","
			+ "\"lastUpdateTime\":\"2020-07-17\"}";
	
	
	/*
	 * 
	 * 
	 *
	
	   String abc= "{\"orderId\":\"1\"+
	    "\"customerDetails\": {
	        \"emailAddress\": \"hg@gmail.com\"+
	        \"fullName\": \"ghh\"+
	        \"password\": \"123qdse34\"+
	        \"phoneNumber\": \"1234567890\"+
	        \"city\": \"huhj\"+
	        \"zipCode\": \"654789\"+
	        \"country\": \"gyuh\"+
	        \"registerDate\": \"2020-11-11\"
	    },
	    \"shippingAddress\": \"gghvb\"+
	    \"quantity\": 15+
	    \"subTotal\": 2000+
	    \"total\": 8888.0+
	    \"orderStatus\": \"shipped\"+
	    \"paymentMethod\": \"online\"+
	    \"orderDate\": null+
	    \"book\": null
	}";
	*/
	
	/*
	
	@Test
	public void testViewOrderDetails() throws Exception {
		int orderId=1;
		//String categoryJson = "{\"categoryName\":\"\"}";
		String expectedResult="Cannot add empty category";
		Mockito.when(
				bookService.viewOrderDetails(orderId))).thenReturn(expectedResult);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/manageCategory/create").accept(MediaType.APPLICATION_JSON).content(categoryJson).contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
                .string("Cannot add empty category")).andDo(MockMvcResultHandlers.print());
	}
	*/
	
	
	
	
	
	
	
	
	