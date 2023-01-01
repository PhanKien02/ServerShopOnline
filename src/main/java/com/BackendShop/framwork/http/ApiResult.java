package com.BackendShop.framwork.http;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResult {

	public static ResponseEntity<ResponseData> success() {
		
		return respoonse(HttpStatus.OK, "Operation was successful", new ResponseData());
	}
	
	public static ResponseEntity<ResponseData> success(ResponseData data) {
		
		return respoonse(HttpStatus.OK, "Operation was successful", data);
	}
	
	public static ResponseEntity<ResponseData> failed() {
		
		return respoonse(HttpStatus.BAD_REQUEST, "Operation was failes", new ResponseData());
	}
	
	public static ResponseEntity<ResponseData> failed(String message) {
		
		return respoonse(HttpStatus.BAD_REQUEST, "Operation was successful", new ResponseData());
	}
	
	public static ResponseEntity<ResponseData> respoonse(HttpStatus httpStatus, String message,ResponseData data){
		
		if(data == null)
		{
			data = new ResponseData();
		}
		if(httpStatus.equals(HttpStatus.OK)) {
			data.setStatusCode(httpStatus.OK);
			data.setIsSuccess(true);
		}
		else {
			data.setIsSuccess(false);
			data.setErrorMessage(message);
			data.setData(null);
		}	
		return ResponseEntity.status(httpStatus).body(data);
	}
}
