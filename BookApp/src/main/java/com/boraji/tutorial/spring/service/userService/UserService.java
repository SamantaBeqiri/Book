package com.boraji.tutorial.spring.service.userService;

import com.boraji.tutorial.spring.dto.userDto.ChangePasswordDto;
import com.boraji.tutorial.spring.dto.userDto.UserCreateDto;
import com.boraji.tutorial.spring.dto.userDto.UserDto;
import com.boraji.tutorial.spring.dto.userDto.UserUpdateDto;
import com.boraji.tutorial.spring.model.User;

public interface UserService {
	
	UserDto addUser(UserCreateDto userPostDto);
	UserDto findUser(Integer id);
	UserDto updateUser(Integer id, UserUpdateDto userUpdateDto);
	User findByUsername(String username);
	void changePassword(Integer userId, ChangePasswordDto changePasswordDto);

}
