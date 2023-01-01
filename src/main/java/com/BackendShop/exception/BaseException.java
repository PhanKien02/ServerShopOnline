package com.BackendShop.exception;

public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2580130121502117304L;

	public BaseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BaseException(String message) {
		super(message);
		
	}
	
  
}
