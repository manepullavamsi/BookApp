package com.Legato.demo.BookApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Legato.demo.BookApp.Model.Book;
import com.Legato.demo.BookApp.Model.User;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{

	List<Book> findByUser(User user);

	
	
}