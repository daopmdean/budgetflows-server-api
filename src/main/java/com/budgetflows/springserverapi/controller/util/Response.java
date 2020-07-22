package com.budgetflows.springserverapi.controller.util;

public class Response {
	private Object data;
	private Error error;

	public Response() {
	}

	public Response(Object data, Error error) {
		this.data = data;
		this.error = error;
	}
	
	public static Response success(Object data) {
		return new Response(data, null);
	}
	
	public static Response error(Error error) {
		return new Response(null, error);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

}
