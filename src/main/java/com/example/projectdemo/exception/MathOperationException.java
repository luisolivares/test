package com.example.projectdemo.exception;

public class MathOperationException extends Exception {

	private static final long serialVersionUID = -268987297232002128L;

	public MathOperationException() {
		super();
	}

	public MathOperationException(final String message) {
		super(message);
	}

}