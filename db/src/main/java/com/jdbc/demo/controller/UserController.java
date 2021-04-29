package com.jdbc.demo.controller;

import com.jdbc.demo.entity.JpaUser;
import com.jdbc.demo.entity.User;
import com.jdbc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findUserById")
    public User findUserById(@RequestParam Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/selectUserList")
    public List<User> selectUserList() {
        return userService.selectUserList();
    }

    @PostMapping("/saveUser")
    @ResponseBody
    public JpaUser saveUser(@RequestBody JpaUser user) {
        return userService.saveUser(user);
    }

    @GetMapping("/findJpaUserById")
    public JpaUser selectUserList(Long id) {
        return userService.findJpaUserById(id);
    }

    @GetMapping("/queryById")
    public List<JpaUser> queryById(String userName) {
        return userService.queryById(userName);
    }

    @GetMapping("/queryPageById")
    public Page<JpaUser> selectUserList(Pageable pageable) {
        return userService.queryPageById(pageable);
    }
}
