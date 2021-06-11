package com.example.exception;

import com.example.http.Error;

public class ResponseException extends RuntimeException {

	private static final long serialVersionUID = -62308275198426352L;
	
	private Error error;
	
	public ResponseException(Error error) {
		 this.setError(error);
	}
	
	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

}
