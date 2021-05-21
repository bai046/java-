package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Role;
import com.example.mapper.RoleMapper;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> getRolesByUserId(Long userId) {
		return roleMapper.getRolesByUserId(userId);
	}

}
