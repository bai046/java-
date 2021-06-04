package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.http.Api;
import com.example.http.Response;

@RestController
@RequestMapping({ "${server.error.path:${error.path:/error}}" })
public class MyErrorController implements ErrorController {

	@RequestMapping
	public Response<Object> error(HttpServletRequest request, HttpServletResponse response) {
		HttpStatus status = this.getStatus(request, response);
		return Api.failure(status.value(), status.getReasonPhrase());
	}

	public HttpStatus getStatus(HttpServletRequest request, HttpServletResponse response) {
		Integer status = response.getStatus();
		try {
			if (status != null) {
				return HttpStatus.valueOf(status);
			}
		} catch (Exception e) {
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

	@Override
	public String getErrorPath() {
		return null;
	}
	
}