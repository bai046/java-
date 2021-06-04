package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDTO;

@RestController
@RequestMapping("/test")
public class TestController {

	@PostMapping
	public Map<Object, Object> test(
		@Validated @RequestBody UserDTO dto, 
		BindingResult bindingResult
	) {
		
		Map<Object, Object> res = new HashMap<>();
		if (bindingResult.hasErrors()) {
			res.put("code", 400);
			res.put("msg", bindingResult.getFieldError().getDefaultMessage());
			res.put("data", null);
		} else {
			res.put("code", 200);
			res.put("msg", "ok");
			res.put("data", dto);
		}
		
		return res;
	}
}