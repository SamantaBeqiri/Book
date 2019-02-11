package com.boraji.tutorial.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.spring.dto.BookCreateDto;
import com.boraji.tutorial.spring.dto.BookDto;
import com.boraji.tutorial.spring.model.Book;
import com.boraji.tutorial.spring.service.BookService;

@RestController
@RequestMapping(value="/api/book")
public class BookController {
	@Autowired 
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<BookDto> save (@RequestBody BookCreateDto bookPostDto){
	
		return ResponseEntity.ok(bookService.save(bookPostDto));
		
	}

}
