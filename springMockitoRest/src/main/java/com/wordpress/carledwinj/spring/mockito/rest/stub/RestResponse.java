package com.wordpress.carledwinj.spring.mockito.rest.stub;

import org.springframework.http.HttpStatus;

public class RestResponse<T> {

	private boolean success;
	
	private String message;
	
	private T data;
	
	private HttpStatus status;
	
	public RestResponse(boolean success, String message, HttpStatus status, T data) {
		super();
		this.success = success;
		this.message = message;
		this.setStatus(status);
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
