package com.wordpress.carledwinj.spring.mockito.rest.exception;

public class UnknownResourceException  extends RuntimeException{

	private static final long serialVersionUID = -6443821416209265342L;

	public UnknownResourceException(String message) {
		super(message);
	}
}
