package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.boraji.tutorial.spring.model.Book;

@Repository
public class BookDaoImplementation implements BookDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Book save(Book book) {
		entityManager.persist(book);
		
		return book;
	}
	public Book get(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public List<Book> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(long id, Book book) {
		// TODO Auto-generated method stub
		
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	

}
