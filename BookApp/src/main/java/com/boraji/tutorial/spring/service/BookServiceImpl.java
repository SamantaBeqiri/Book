package com.boraji.tutorial.spring.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.tutorial.spring.converter.BookConverter;
import com.boraji.tutorial.spring.dao.BookDao;
import com.boraji.tutorial.spring.dto.BookCreateDto;
import com.boraji.tutorial.spring.dto.BookDto;
import com.boraji.tutorial.spring.model.Book;
import com.boraji.tutorial.spring.util.LoggerUtil;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	private static final BookConverter BOOK_CONVERTER=new BookConverter();
	private static final Logger LOGGER=Logger.getLogger(BookServiceImpl.class);
	private static final LoggerUtil LOGGER_UTIL =new LoggerUtil();
	@Autowired
	private BookDao bookDao;
	
	
	public BookDto save (BookCreateDto bookCreateDto) {
		Book book=BOOK_CONVERTER.convert(bookCreateDto);
		LOGGER.debug(LOGGER_UTIL.started("adding a book", bookCreateDto.toString()));
		LOGGER.debug(LOGGER_UTIL.finished("adding a book"));
		return  BOOK_CONVERTER.toGetDto(bookDao.save(book));
		
		
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
