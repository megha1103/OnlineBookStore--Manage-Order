package com.cg.bookStore.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.bookStore.exceptions.BookIdException;
import com.cg.bookStore.exceptions.BookIdNotFoundException;
import com.cg.bookStore.util.OrderConstraints;

@ControllerAdvice

public class BookStoreExceptionAdvice {
	
	Logger logger = LoggerFactory.getLogger(BookStoreExceptionAdvice.class);

	
	@ExceptionHandler(value = {BookIdNotFoundException.class})
	@ResponseStatus(code= HttpStatus.NOT_FOUND)
	@ResponseBody
	public Map<String,String> handlerException1(Exception ex) {
		logger.error(ex.getMessage());
		Map<String,String> map = new HashMap<>();
		map.put("message", OrderConstraints.BOOK_ID_NOT_Found);
		return map;
	}
	
	@ExceptionHandler(value = {BookIdException.class})
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String,String> handlerException2(Exception ex) {
		logger.error(ex.getMessage());
		Map<String,String> map = new HashMap<>();
		map.put("message", OrderConstraints.BOOK_Id_EXCEPTION);
		return map;

		
	}

}