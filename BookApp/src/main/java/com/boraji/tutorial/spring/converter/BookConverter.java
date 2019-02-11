package com.boraji.tutorial.spring.converter;

import com.boraji.tutorial.spring.dto.BookCreateDto;
import com.boraji.tutorial.spring.dto.BookDto;
import com.boraji.tutorial.spring.model.Book;

public class BookConverter {
	
	

	public Book convert(BookCreateDto recipePostDto) {
		Book book=new Book();
		book.setAuthor(recipePostDto.getAuthor());
		book.setTitle(recipePostDto.getTitle());
		
		return book;
	}
	
	public BookDto toGetDto(Book book) {
		BookDto toReturn=new BookDto();
		toReturn.setId(book.getId());
		toReturn.setTitle(book.getTitle());
		toReturn.setAuthor(book.getAuthor());
		
		return toReturn;
		
	}
}
 