package com.Legato.demo.BookApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Legato.demo.BookApp.Model.Book;
import com.Legato.demo.BookApp.Model.Recommendation;
import com.Legato.demo.BookApp.Model.User;


@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation,Integer>{

	List<Recommendation> findByUser(User user);


	
}