package com.jdbc.demo.service;

import com.jdbc.demo.entity.JpaUser;
import com.jdbc.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    public User findUserById(Long id);

    public List<User> selectUserList();

    JpaUser saveUser(JpaUser jpaUser);

    JpaUser findJpaUserById(Long id);

    List<JpaUser> queryById(String userName);

    List<JpaUser> findAllByName(String userName);

    Page<JpaUser> queryPageById(Pageable pageable);
}
