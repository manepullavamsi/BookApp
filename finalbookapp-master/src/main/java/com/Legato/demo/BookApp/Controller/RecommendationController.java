package com.Legato.demo.BookApp.Controller;

import java.util.HashMap;
import java.util.List;

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
import com.Legato.demo.BookApp.Model.Recommendation;
import com.Legato.demo.BookApp.Model.User;
import com.Legato.demo.BookApp.Model.UserAuthentication;
import com.Legato.demo.BookApp.Repository.BookRepository;
import com.Legato.demo.BookApp.Repository.RecommendationRepository;
import com.Legato.demo.BookApp.Service.BookService;
import com.Legato.demo.BookApp.Service.RecommendationService;


@RestController
public class RecommendationController {

	@Autowired
	RecommendationRepository repo;
	
	@Autowired
	private RecommendationService recService;

	@GetMapping("/recommendations")
	public List<Recommendation> getfavourites() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			User loggedinUser = ((UserAuthentication) principal).getUser();
			System.out.println(loggedinUser);
			List<Recommendation> books = recService.findAllBookByUser(loggedinUser);
			for (int i = 0; i < books.size(); i++) {
				System.out.println(books.get(i).getRecbookName());
			}
		
			return books;
	}


	@PostMapping(value = "/addrecommendations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity addRecommendations(@RequestBody Recommendation book) {
		HashMap<String, String> responseMap = new HashMap<>();

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			User loggedinUser = ((UserAuthentication) principal).getUser();
			Recommendation book1 = new Recommendation();
			book1.setRecbookAuthor(book.getRecbookAuthor());
				System.out.println(book.getRecbookAuthor());
			book1.setRecbookName(book.getRecbookName());
				System.out.println(book.getRecbookName());
			book1.setRecbookImage(book.getRecbookImage());
			book1.setUserRec(loggedinUser);
			
			recService.saveBook(book1);
			responseMap.put("Added", "New Book Added to your list");
		} else {

			responseMap.put("Error", "Cannot Add Book to list");

		}
		return new ResponseEntity<>(responseMap, HttpStatus.OK);
	}


	@DeleteMapping("/deleterecommendations")
	public ResponseEntity deleteFavourites(@RequestBody Recommendation book) {
		
		
		List<Recommendation> books=getfavourites();
		int id=0;
		for(int i=0;i<books.size();i++) {
			if(books.get(i).getRecbookName().equals(book.getRecbookName())) {
				id=books.get(i).getRecbookId();
				break;
			}
		}
		repo.deleteById(id);
		System.out.println(book.getRecbookName()+book.getRecbookAuthor());
		System.out.println("deleted");
		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}

}
