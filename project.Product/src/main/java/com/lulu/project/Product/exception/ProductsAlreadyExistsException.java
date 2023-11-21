package com.lulu.project.Product.exception;

public class ProductsAlreadyExistsException extends RuntimeException {
private static final long serialVersionUID = 1L;
 
	private String message;
 
	public ProductsAlreadyExistsException() {
 
	}
 
	public ProductsAlreadyExistsException(String msg) {
 
		super(msg);
 
		this.message = msg;
 
	}
 
}
