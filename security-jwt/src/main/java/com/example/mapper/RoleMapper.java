package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.entity.Role;

@Mapper
public interface RoleMapper {
	public List<Role> getRolesByUserId(@Param("userId") Long userId);
}
