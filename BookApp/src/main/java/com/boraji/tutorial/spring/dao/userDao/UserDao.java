package com.boraji.tutorial.spring.dao.userDao;

import com.boraji.tutorial.spring.model.User;

public interface UserDao {

	User save(User user);

	User find(int id);

	User update(User user);

	User findByUsername(String username);

	Boolean ifExists(String username);
}
