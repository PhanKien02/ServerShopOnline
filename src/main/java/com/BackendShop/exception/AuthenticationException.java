package com.BackendShop.exception;

import com.mysql.cj.x.protobuf.Mysqlx.Error.Severity;

public class AuthenticationException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public AuthenticationException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AuthenticationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	public AuthenticationException(String msg, Throwable rootCause) {
		super(msg, rootCause);
		
	}
	
	    
}
