package com.Legato.demo.BookApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Legato.demo.BookApp.Model.Book;
import com.Legato.demo.BookApp.Model.Recommendation;
import com.Legato.demo.BookApp.Model.User;
import com.Legato.demo.BookApp.Repository.BookRepository;
import com.Legato.demo.BookApp.Repository.RecommendationRepository;


@Service
public class RecommendationService {
	@Autowired
	private RecommendationRepository bookrepo;

	public boolean deleteBookById(int id) {
		Recommendation book = bookrepo.findById(id).orElse(null);
		if (book != null) {
			bookrepo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Recommendation> findAllBookByUser(User user) {
		return bookrepo.findByUser(user);
	}

	public boolean deleteBookByBookId(Recommendation book) {
		List<Recommendation> books = findAllBookByUser(book.getUserRec());
		System.out.println("checking book");
		for (int i = 0; i < books.size(); i++) {
			if (book.getRecbookId()==(books.get(i).getRecbookId())) {
				System.out.println("deleted");
				bookrepo.delete(books.get(i));
				return true;
			}
		}

		return false;
	}


	public Recommendation saveBook(Recommendation book) {
		List<Recommendation> books = findAllBookByUser(book.getUserRec());
		for (int i = 0; i < books.size(); i++) {
			if (book.getRecbookId()==(books.get(i).getRecbookId()))  {
				return bookrepo.save(book);

			}
		}

		return bookrepo.save(book);
	}

}

