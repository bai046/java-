package com.yy.FB.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yy.FB.config.RestResult;
import com.yy.FB.config.ResultGenerator;
import com.yy.FB.entity.User;
import com.yy.FB.service.UserService;
import com.yy.FB.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private ResultGenerator generator;


    //管理员登录
    @PostMapping(value = "/admin")
    public RestResult adminLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        System.out.println(username);
        System.out.println(password);
        System.out.println(role);
        Map<String, String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("role",role);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(map,false);
        if(userService.getMap(wrapper).size()!=5)
        {
            return generator.getFailResult("登录失败~~");
        }
        System.out.println("*********************");
        System.out.println(userService.getMap(wrapper).size());
        String token = JwtUtil.getToken(map);
        return generator.getTokenResult(token);
    }


    //企业登录
    @PostMapping(value = "/company")
    public RestResult companyLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        System.out.println(username);
        System.out.println(password);
        System.out.println(role);
        Map<String, String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("role",role);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(map,false);
        if(userService.getMap(wrapper).size()!=16) {
            return generator.getFailResult("登录失败~~");
        }
        System.out.println("*********************");
        System.out.println(userService.getMap(wrapper).size());
        String token = JwtUtil.getToken(map);
        return generator.getTokenResult(token);
    }



    //工作室登录
    @PostMapping(value = "/studio")
    public RestResult studioLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        System.out.println(username);
        System.out.println(password);
        System.out.println(role);
        Map<String, String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("role",role);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.allEq(map,false);
        if(userService.getMap(wrapper).size()!=21)
        {
            return generator.getFailResult("登录失败~~");
        }
        System.out.println("*********************");
        System.out.println(userService.getMap(wrapper).size());
        String token = JwtUtil.getToken(map);
        return generator.getTokenResult(token);
    }



    @PostMapping(value = "/token")
    public Map<String, Object> token() {
        Map<String, Object> map = new HashMap<>();
        map.put("state", true);
        map.put("msg", "请求成功");
        return map;
    }
}
