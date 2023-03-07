package com.app.custom_exception;

@SuppressWarnings("serial")
public class ProductAlreadyPresent extends RuntimeException{
	public ProductAlreadyPresent(String message) {
		super(message);
	}
}
