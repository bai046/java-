package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.http.Response;
import com.example.http.Api;
import com.example.http.Error;
import com.example.service.UserService;

@RestController
public class UserController extends BaseController {
	
	  @Autowired
	  private UserService userService;

    @GetMapping("/user/data")
    public Response<String> getUserData() {
    	return Api.success("userData");
    }

    @GetMapping("/admin/data")
    public Response<String> getAdminData() {
      return Api.success("adminData");
    }
    
    @GetMapping("/forbidden")
    public Response<Object> forbidden() {
      return Api.failure(Error.USER_NO_PERMISSION);
    }
    
    @GetMapping("/csrf")
    public Response<CsrfToken> csrf(CsrfToken token) {
    	return Api.success(token);
    }
    
    @GetMapping("/exception")
    public Response<Object> testException(
    		@RequestParam(value = "isThrow", defaultValue = "0") int isThrow
    ) {
    	String[] data = userService.testException(isThrow == 0 ? false : true);
    	return Api.success(data);
    }
    
}
