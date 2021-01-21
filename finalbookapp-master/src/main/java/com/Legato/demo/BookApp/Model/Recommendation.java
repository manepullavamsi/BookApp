package com.Legato.demo.BookApp.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.StringIdGenerator.class,
//        property="user")
@Entity
@Table(name="recommendation")
public class Recommendation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//public int Id;
	//@Column(name="BOOK_ID", updatable=false, nullable=false)
	private int recbookId;
	
	@Column(name="recbookName")
	private String recbookName;
	
	@Column(name="recbookAuthor")
	private String recbookAuthor;
	
	@Column(name="recbookImage")
	private String recbookImage;
	
	//private Set<User> users;

	
	public Recommendation() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

	

	public int getRecbookId() {
		return recbookId;
	}


	public void setRecbookId(int recbookId) {
		this.recbookId = recbookId;
	}


	public String getRecbookName() {
		return recbookName;
	}


	public void setRecbookName(String recbookName) {
		this.recbookName = recbookName;
	}


	public String getRecbookAuthor() {
		return recbookAuthor;
	}


	public void setRecbookAuthor(String recbookAuthor) {
		this.recbookAuthor = recbookAuthor;
	}


	public String getRecbookImage() {
		return recbookImage;
	}


	public void setRecbookImage(String recbookImage) {
		this.recbookImage = recbookImage;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}




	@ManyToOne
	    @JoinColumn(name ="uid")
	  @JsonManagedReference(value="user-movement")
		@JsonIgnore
	    private User user;

	public User getUserRec() {
		return user;
	}


	public void setUserRec(User user) {
		this.user = user;
	}
	
	
}
