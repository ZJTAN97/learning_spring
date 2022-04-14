package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private HttpStatus status;
	private String message;

	public BlogAPIException(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
