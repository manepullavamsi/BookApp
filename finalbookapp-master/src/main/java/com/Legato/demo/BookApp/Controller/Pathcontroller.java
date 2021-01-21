package com.Legato.demo.BookApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pathcontroller {
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	@GetMapping("/myprofile")
	public String profilePage() {
		return "profile.html";
	}
	@GetMapping("/login")
	public String loginPage() {
		return "login.html";
	}
	@GetMapping("/signup")
	public String signUp() {
		return "sign.html";
	}
	@GetMapping("/search")
	public String search() {
		return "search.html";
	}
	@GetMapping("/books")
	public String dashboard() {
		return "dashboard.html";
	}
	@GetMapping("/favourite")
	public String Favourite() {
		return "Favourite.html";
	}
	@GetMapping("/recommendation")
	public String Recommendation() {
		return "Recommendation.html";
	}
}
