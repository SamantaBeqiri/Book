package com.boraji.tutorial.spring.security.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.boraji.tutorial.spring.dao.userDao.UserDao;
import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.security.service.UserPrincipal;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserDao userDao;


	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userDao.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User not found with email "+username);
		}
		
		return UserPrincipal.build(user);
		
		
		
	}

}
