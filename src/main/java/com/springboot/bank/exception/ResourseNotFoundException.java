package com.springboot.bank.exception;

public class ResourseNotFoundException extends RuntimeException{

	public ResourseNotFoundException() {
		
	}
	
	public ResourseNotFoundException(String msg) {
		super(msg);
	}
}
