package com.project.Customer.exception;



	public class CustomerAlreadyExistsException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		private String message;


		public CustomerAlreadyExistsException(String msg) {
			super(msg);
		}
	}

