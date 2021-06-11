package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.http.Api;
import com.example.util.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
  private JwtToken jwtToken;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("token", jwtToken.generateToken(user));
		
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(JsonUtils.toJSONString(Api.success(map)));
	}
}
