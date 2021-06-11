package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.http.Response;
import com.example.http.Api;
import com.example.http.Error;
import com.example.service.UserService;
import com.example.util.PasswordUtils;

import io.jsonwebtoken.impl.Base64Codec;

@RestController
public class UserController extends BaseController {
	
		@Value("${myapp.user.password.secret}")
		private String secret;
	
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
    
    @GetMapping("/encode/{password}")
  	public Response<String> encode(@PathVariable("password") String password) {
  		return Api.success(PasswordUtils.getCryptPassword(password, this.secret));
  	}
    
    @GetMapping("/encode/base64/{secret}")
    public Response<String> encodeBase64(@PathVariable("secret") String secret) {
    	Base64Codec  codec = new Base64Codec();
    	return Api.success(codec.encode(secret));
    }
    
    @GetMapping("/exception")
    public Response<Object> testException(
    		@RequestParam(value = "isThrow", defaultValue = "0") int isThrow
    ) {
    	String[] data = userService.testException(isThrow == 0 ? false : true);
    	return Api.success(data);
    }
    
    @GetMapping("/user/test")
    public Response<Object> test() {
    	return Api.success(new int[]{1, 2, 3, 4});
    }
    
}
