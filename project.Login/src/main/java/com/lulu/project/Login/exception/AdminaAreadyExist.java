package com.lulu.project.Login.exception;

public class AdminaAreadyExist extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	 
	private String message;
 
	public AdminaAreadyExist() {
 
	}
 
	public AdminaAreadyExist(String msg) {
 
		super(msg);
 
		this.message = msg;
 
	}

}
