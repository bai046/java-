package com.example.service;

import java.util.List;

import com.example.entity.Role;

public interface UserRoleService {
	public List<Role> getRolesByUserId(Long userId);
}
