package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.tutorial.spring.dto.BookCreateDto;
import com.boraji.tutorial.spring.dto.BookDto;
import com.boraji.tutorial.spring.model.Book;

public interface BookService {
	BookDto save(BookCreateDto book);
	List<Book> list();
	void update(long id,Book book);
	void delete(long id);
	

}
