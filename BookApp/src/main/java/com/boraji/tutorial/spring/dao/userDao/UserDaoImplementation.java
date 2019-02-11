package com.boraji.tutorial.spring.dao.userDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.security.exception.BookAppNotFoundException;
import com.boraji.tutorial.spring.security.exception.NotFound;
@Repository
public class UserDaoImplementation implements UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	public User save(User user) {
		entityManager.persist(user);
		return user;
	}

	public User find(int id) {
		String queryString ="FROM User user WHERE user.id=?1";
		try {
		return entityManager.createQuery(queryString,User.class).setParameter(1, id).getSingleResult();
		}
		catch(Exception e ){
			throw new BookAppNotFoundException(NotFound.USER);
			
		}
	
	}

	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByUsername(String username) {
	String queryString="From User user where user.username=?1";
	
	try {
		return entityManager.createQuery(queryString,User.class).setParameter(1, username).getSingleResult();
	}
     catch(Exception e) {
    	 throw new BadCredentialsException("wrong username or password");
     }
	}

	public Boolean ifExists(String username) {
		String queryString ="SELECT COUNT (user) FROM User user where user.username =?1";
		Query query =entityManager.createQuery(queryString).setParameter(1,username);
		Long count=(Long)query.getSingleResult();
		return count.equals(1L);
	}

}
