package com.BackendShop.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mysql.cj.x.protobuf.Mysqlx.Error.Severity;


@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class AlreadyUserException  extends BaseException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AlreadyUserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlreadyUserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AlreadyUserException(String msg, Throwable rootCause) {
		super(msg,rootCause);
	}

	
}
