package com.Legato.demo.BookApp.Model;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue
	private int Id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	
	@OneToMany(mappedBy="user")
	@JsonBackReference
    private Set<Book> books;
	
	@OneToMany(mappedBy="user")
	@JsonBackReference(value="user-movement")
	private Set<Recommendation> rec;
	
	public Set<Recommendation> getRec() {
		return rec;
	}

	public void setRec(Set<Recommendation> rec) {
		this.rec = rec;
	}

	private String img;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}



	

}