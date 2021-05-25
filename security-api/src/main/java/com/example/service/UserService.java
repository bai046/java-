package com.example.service;

import com.example.entity.User;

public interface UserService {
	
	public User getOneByUsername(String username);

	public String[] testException(boolean isThrow);
	
}
