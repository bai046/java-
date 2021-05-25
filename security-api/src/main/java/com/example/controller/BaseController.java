package com.example.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.ResponseException;
import com.example.http.Api;
import com.example.http.Response;

public class BaseController {
	
	@ExceptionHandler({ResponseException.class})
	protected Response<Object> handleResponseError(ResponseException e) {
		return Api.failure(e.getError());
	}
	
}
