package com.boraji.tutorial.spring.dto;

public class BookCreateDto {
	
	private String author;
	private String title;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "BookCreateDto [author=" + author + ", title=" + title + "]";
	}
	
	

}