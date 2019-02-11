package com.boraji.tutorial.spring.service.userService;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.converter.UserConverter;
import com.boraji.tutorial.spring.dao.userDao.UserDao;
import com.boraji.tutorial.spring.dto.userDto.ChangePasswordDto;
import com.boraji.tutorial.spring.dto.userDto.UserCreateDto;
import com.boraji.tutorial.spring.dto.userDto.UserDto;
import com.boraji.tutorial.spring.dto.userDto.UserUpdateDto;
import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.security.exception.BookAppBadRequestException;
import com.boraji.tutorial.spring.util.LoggerUtil;
@Service
@Transactional
public class UserServiceImplementation implements UserService{
	
	private static final Logger LOGGER=Logger.getLogger(UserServiceImplementation.class);
	private static final UserConverter USER_CONVERTER=new UserConverter();
	private static final LoggerUtil LOGGER_UTIL=new LoggerUtil();
	@Autowired
private PasswordEncoder  passwordEncoder;
	@Autowired
	UserDao userDao;
	
	

	public UserDto addUser(UserCreateDto userCreateDto) {
		
		LOGGER.debug(LOGGER_UTIL.started("adding user", userCreateDto.toString()));
		if(userDao.ifExists(userCreateDto.getUsername())) {
			throw new BookAppBadRequestException("This username already exists");
			
		}
		userCreateDto.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
		User user=USER_CONVERTER.convert(userCreateDto);
		LOGGER.debug(LOGGER_UTIL.finished("adding user"));
		
		
		return USER_CONVERTER.toGetDto(userDao.save(user));
	}

	public UserDto findUser(Integer id) {
		LOGGER.debug(LOGGER_UTIL.started("Finding user with id=",id.toString()));
		User user=userDao.find(id);
		LOGGER.debug(LOGGER_UTIL.finished("finding user"));
		return USER_CONVERTER.toGetDto(user);
		
	}

	public UserDto updateUser(Integer id, UserUpdateDto userUpdateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByUsername(String username) {
		LOGGER.debug(LOGGER_UTIL.started("finding user with username", username));
		return userDao.findByUsername(username);
	}

	public void changePassword(Integer userId, ChangePasswordDto changePasswordDto) {
		// TODO Auto-generated method stub
		
	}

	
}
