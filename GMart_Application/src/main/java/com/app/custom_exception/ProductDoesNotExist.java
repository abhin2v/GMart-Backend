package com.app.custom_exception;

@SuppressWarnings("serial")
public class ProductDoesNotExist extends Exception{
	public ProductDoesNotExist(String message) {
		super(message);
	}
}