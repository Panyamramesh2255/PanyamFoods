package com.foods.panyam.response;

import java.io.Serializable;

public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int statusCode;
	Object data;
	String message;
	public Response(int statusCode, Object data, String message) {
		super();
		this.statusCode = statusCode;
		this.data = data;
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
