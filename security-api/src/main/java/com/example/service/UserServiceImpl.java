package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.exception.ResponseException;
import com.example.http.Error;
import com.example.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getOneByUsername(String username) {
		return userMapper.getOneByUsername(username);
	}

	@Override
	public String[] testException(boolean isThrow) {
		if (isThrow) {
			throw new ResponseException(Error.USER_ACCOUNT_EXPIRED);
		}
		return new String[]{"data1", "data2", "正常", "恭喜，无异常"};
	}

}
