package com.example.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.util.StringUtils;

public class PasswordUtils {
	
	public static String getCryptPassword(String password) {
		return getPasswordEncoder(null).encode(password);
	}
	
	public static String getCryptPassword(String password, String secret) {
		return getPasswordEncoder(secret).encode(password);
	}
	
	public static PasswordEncoder getPasswordEncoder(String secret) {
		PasswordEncoder encoder;
		if (StringUtils.hasLength(secret)) {
			encoder = new Pbkdf2PasswordEncoder(secret);
  	} else {
  		encoder = new BCryptPasswordEncoder();
  	}
		return encoder;
	}

}
