package com.Legato.demo.BookApp.Controller;

import java.util.HashMap;
import java.util.List;


import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Legato.demo.BookApp.Model.Book;
import com.Legato.demo.BookApp.Model.User;
import com.Legato.demo.BookApp.Model.UserAuthentication;
import com.Legato.demo.BookApp.Repository.BookRepository;
import com.Legato.demo.BookApp.Service.BookService;



@RestController
public class BookController {

	@Autowired
	BookRepository repo;
	
	@Autowired
	private BookService bookservice;

	@GetMapping("/favourites")
	public List<Book> getfavourites() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			User loggedinUser = ((UserAuthentication) principal).getUser();
			System.out.println(loggedinUser);
			List<Book> books = bookservice.findAllBookByUser(loggedinUser);
			for (int i = 0; i < books.size(); i++) {
				System.out.println(books.get(i).getBookName());
			}
		
			return books;
	}


	@PostMapping(value = "addfavourites", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity addFAvourite(@RequestBody Book book) {
		HashMap<String, String> responseMap = new HashMap<>();

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			User loggedinUser = ((UserAuthentication) principal).getUser();
			Book book1 = new Book();
			book1.setBookAuthor(book.getBookAuthor());
				System.out.println(book.getBookAuthor());
			book1.setBookName(book.getBookName());
				System.out.println(book.getBookName());
			book1.setBookImage(book.getBookImage());
			book1.setUser(loggedinUser);
			
			bookservice.saveBook(book1);
			responseMap.put("Added", "New Book Added to your list");
		} else {

			responseMap.put("Error", "Cannot Add Book to list");

		}
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}


	@DeleteMapping("/deletefavourites")
	public ResponseEntity deleteFavourites(@RequestBody Book book) {
		
		
		List<Book> books=getfavourites();
		int id=0;
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getBookName().equals(book.getBookName())) {
				id=books.get(i).getBookId();
				break;
			}
		}
		repo.deleteById(id);
		System.out.println(book.getBookName()+book.getBookAuthor());
		System.out.println("deleted");
		return new ResponseEntity<>("", HttpStatus.OK);
	}
//		HashMap<String, String> responseMap = new HashMap<>();
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if (principal instanceof UserDetails) {
//			User loggedinUser = ((UserAuthentication) principal).getUser();
//
//			//book.setBookId(String.valueOf(id));
//			book.setUser(loggedinUser);
//			if(bookservice.deleteBookByBookId(book))
//				System.out.println("book con===deleted");
//			else
//				responseMap.put("Error", "Invalid Match ID");	
//		} else {
//			responseMap.put("Error", "Recommendation cannot be deleted");
//		}
//		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	


}
