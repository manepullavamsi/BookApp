package com.Legato.demo.BookApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Legato.demo.BookApp.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByEmail(String email);
	Optional<User> findByName(String name);
	
}
