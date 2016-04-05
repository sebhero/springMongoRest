package com.sebhero.controller;

import com.sebhero.model.Book;
import com.sebhero.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sebastian Börebäck on 2016-04-04.
 * updated 20150405 test
 */

//localhost:63342

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * Create add book
	 * @param bookMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createBook(@RequestBody Map<String, Object> bookMap){
		Book book = new Book(bookMap.get("name").toString(),
				bookMap.get("isbn").toString(),
				bookMap.get("author").toString(),
				Integer.parseInt(bookMap.get("pages").toString()));

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Book created successfully");
		response.put("book", bookRepository.save(book));
		return response;
	}

	/**
	 * Get a book by id
	 * @param bookId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
	public Book getBookDetails(@PathVariable("bookId") String bookId) {
		return bookRepository.findOne(bookId);
	}

	/**
	 * Edit a book by Id
	 * @param bookId
	 * @param bookMap
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{bookId}")
	public Map<String, Object> editBook(@PathVariable("bookId") String bookId,
	                                    @RequestBody Map<String, Object> bookMap) {
		Book book = new Book(bookMap.get("name").toString(),
				bookMap.get("isbn").toString(),
				bookMap.get("author").toString(),
				Integer.parseInt(bookMap.get("pages").toString())
		);
		book.setId(bookId);

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Book Updated successfully");
		response.put("book", bookRepository.save(book));
		return response;

	}

	/***
	 * Delete a book
	 * @param bookId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
	public Map<String, String> deleteBook(@PathVariable("bookId") String bookId) {

		bookRepository.delete(bookId);
		Map<String, String> response = new HashMap<>();
		response.put("message", "Book deleted succesfully");

		return response;
	}

	/**
	 * Get all books
	 * @return
	 */
	//crossOrigin gor satt webinterface kan vara po en
	//annan server
	//ip och port ar webservers koppling
	@CrossOrigin(origins = "http://localhost:63342")
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("totalBooks", books.size());
		response.put("books", books);
		return response;
	}
}

