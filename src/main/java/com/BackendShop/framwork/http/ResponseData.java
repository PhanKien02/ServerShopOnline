package com.BackendShop.framwork.http;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

public class ResponseData {
	 	private Boolean isSuccess;
	    private String errorMessage;
	    private HttpStatus statusCode;
	    private HashMap<String, Object> data;
	    
	    
		public ResponseData() {
			this.data = new HashMap<>();
		}
		
	    public void addData(String key, Object data) {
	        this.data.put(key, data);
	    }
		public Boolean getIsSuccess() {
			return isSuccess;
		}
		public void setIsSuccess(Boolean isSuccess) {
			this.isSuccess = isSuccess;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		public HttpStatus getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(HttpStatus statusCode) {
			this.statusCode = statusCode;
		}
		public HashMap<String, Object> getData() {
			return data;
		}
		public void setData(HashMap<String, Object> data) {
			this.data = data;
		}
	    
	    
}
