package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.service.UserRoleService;
import com.example.service.UserService;

@Controller
public class TestController  {
	
	@Value("${myapp.user.password.secret}")
	private String secret;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout/page")
	public String logout() {
		return "logout";
	}
	
	@GetMapping("/failure")
	public String failure() {
		return "failure";
	}
	
	@GetMapping("/user/details")
	@ResponseBody
	public User getUser(@RequestParam("username") String username) {
		return userService.getOneByUsername(username);
	}
	
	@GetMapping("/user/roles")
	@ResponseBody
	public List<Role> getRole(@RequestParam("username") String username) {
		User user = userService.getOneByUsername(username);
		return userRoleService.getRolesByUserId(user.getId());
	}
	
	@GetMapping("/user/welcome")
	public String userWelcome() {
		return "welcome";
	}
	
	@GetMapping("/admin/welcome")
	public String adminWelcome() {
		return "welcome";
	}
	
	@GetMapping("/admin/welcome1")
	public String adminWelcome1() {
		return "welcome";
	}
	
	@GetMapping("/admin/welcome2")
	public String adminWelcome2() {
		return "welcome";
	}
	
	@GetMapping("/csrf/form")
	public String csrfPage() {
		return "csrf_form";
	}
	
	@PostMapping("/csrf/commit")
	@ResponseBody
	public Map<String, String> csrfCommit(String name, String describe) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("describe", describe);
		return map;
	}
	
	@GetMapping("/encode/{password}")
	@ResponseBody
	public String encode(@PathVariable("password") String password) {
		PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);
		return passwordEncoder.encode(password);
	}
	
}
