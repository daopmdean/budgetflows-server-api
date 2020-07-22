package com.budgetflows.springserverapi.controller.util;

public class AppException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private int statusCode;
	
	public AppException(String message) {
		super(message);
		statusCode = 400;
	}
	
	public AppException(String message, int status) {
		super(message);
		statusCode = status;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
