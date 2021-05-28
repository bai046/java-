package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Role;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 获取数据库用户信息
		com.example.entity.User user = userService.getOneByUsername(username);
		// 获取数据库角色信息
		List<Role> roleList = userRoleService.getRolesByUserId(user.getId());
		// 权限列表
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		for (Role role : roleList) {
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
			list.add(authority);
		}
		// 创建UserDetails对象，设置用户名、密码和权限
		return new User(user.getUsername(), user.getPassword(), list);
	}

}
