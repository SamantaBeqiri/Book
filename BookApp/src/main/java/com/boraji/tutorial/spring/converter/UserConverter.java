package com.boraji.tutorial.spring.converter;

import com.boraji.tutorial.spring.dto.userDto.UserCreateDto;
import com.boraji.tutorial.spring.dto.userDto.UserDto;
import com.boraji.tutorial.spring.model.User;

public class UserConverter {
	
	public User convert(UserCreateDto userPostDto) {
		User user=new User();
		user.setName(userPostDto.getName());
		user.setEmail(userPostDto.getEmail());
		user.setPassword(userPostDto.getPassword());
		user.setSurname(userPostDto.getSurname());
		user.setUsername(userPostDto.getUsername());
		
		return user;
	}
	
	
	public UserDto toGetDto(User user) {
		UserDto userGetDto =new UserDto();
		userGetDto.setId(user.getId());
		userGetDto.setPassword(user.getPassword());
		userGetDto.setName(user.getName());
		userGetDto.setSurname(user.getSurname());
		userGetDto.setUsername(user.getUsername());
		userGetDto.setEmail(user.getEmail());
		return userGetDto;
		
	}

}
