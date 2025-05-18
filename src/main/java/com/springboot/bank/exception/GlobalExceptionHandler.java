package com.springboot.bank.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Map<String, Object>> exceptionHandler(ResourseNotFoundException rx){
		
		String msg = rx.getMessage();
		
		Map<String, Object> m = new HashMap<>();
		
		m.put("the messages is", msg);
		m.put("Success", false);
		m.put("http", HttpStatus.NOT_ACCEPTABLE);
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(m);
		
	}

}
