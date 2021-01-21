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
public class BookService {
	@Autowired
	private BookRepository bookrepo;

	public boolean deleteBookById(int id) {
		Book book = bookrepo.findById(id).orElse(null);
		if (book != null) {
			bookrepo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Book> findAllBookByUser(User user) {
		return bookrepo.findByUser(user);
	}

	public boolean deleteBookByBookId(Book book) {
		List<Book> books = findAllBookByUser(book.getUser());
		System.out.println("checking book");
		for (int i = 0; i < books.size(); i++) {
			if (book.getBookId()==(books.get(i).getBookId())) {
				System.out.println("deleted");
				bookrepo.delete(books.get(i));
				return true;
			}
		}

		return false;
	}


	public Book saveBook(Book book) {
		List<Book> books = findAllBookByUser(book.getUser());
		for (int i = 0; i < books.size(); i++) {
			if (book.getBookId()==(books.get(i).getBookId()))  {
				return bookrepo.save(book);

			}
		}

		return bookrepo.save(book);
	}
}

