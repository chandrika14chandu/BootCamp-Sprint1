package com.cg.bookstore.exception;

public class ReviewIdAlreadyExistsException extends Exception {

	public ReviewIdAlreadyExistsException(String message) {
		super(message);
	}

	public ReviewIdAlreadyExistsException() {
		super();
	}
}