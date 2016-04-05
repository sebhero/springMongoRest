package com.sebhero.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Sebastian Börebäck on 2016-04-04.
 */
public class Book {

	/**
	 *
	 *
	 application/json
	 {
	 "name":"",
	 "isbn":"",
	 "author":"",
	 "pages":""
	 }

	 curl -H "Content-Type: application/json" -X POST -d '{"name":"test","isbn":"123","author":"seb","pages":"12"}' http://localhost:8080/book
	 {"name":"test","isbn":"123","author":"seb","pages":"12"}
	 */

	@Id
	private String id;
	private String name;
	private String isbn;
	private String author;
	private int pages;

	public Book() {
	}

	public Book(String name, String isbn, String author, int pages) {
		this.name = name;
		this.isbn = isbn;
		this.author = author;
		this.pages = pages;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
}
