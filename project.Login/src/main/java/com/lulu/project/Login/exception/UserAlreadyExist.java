package com.lulu.project.Login.exception;

public class UserAlreadyExist extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	 
	private String message;
 
	public UserAlreadyExist() {
 
	}
 
	public UserAlreadyExist(String msg) {
 
		super(msg);
 
		this.message = msg;
 
	}
 
}
