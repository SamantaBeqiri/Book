package com.boraji.tutorial.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.spring.dto.userDto.UserCreateDto;
import com.boraji.tutorial.spring.dto.userDto.UserDto;
import com.boraji.tutorial.spring.service.BookService;
import com.boraji.tutorial.spring.service.userService.UserService;

@RestController
@RequestMapping(value="api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
	@PostMapping(value = "/signup")
	public ResponseEntity<UserDto>addUser(@Valid @RequestBody UserCreateDto userPostDto ){
		return ResponseEntity.ok(userService.addUser(userPostDto));
		
	}

}
