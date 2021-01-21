package com.Legato.demo.BookApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Legato.demo.BookApp.Model.User;
import com.Legato.demo.BookApp.Model.UserAuthentication;
import com.Legato.demo.BookApp.Repository.UserRepository;


@Service
public class LoginService implements UserDetailsService {
	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Login Service");
		//Optional<User> user=userRepo.findByEmail(username);
		Optional<User> user=userRepo.findByName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found"));	
		System.out.println("User found");
		return user.map(UserAuthentication::new).get();
		 
	}
}