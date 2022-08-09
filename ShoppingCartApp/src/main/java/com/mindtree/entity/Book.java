package com.mindtree.entity;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="productId")
public class Book  extends Product{
  
	
	private String genre;
	private String author;
	private String publication;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int productId, String productName, float price, String category) {
		super(productId, productName, price, category);
		// TODO Auto-generated constructor stub
	}
	public Book(String genre, String author, String publications) {
		super();
		this.genre = genre;
		this.author = author;
		this.publication = publications;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	
	@Override
	public String toString() {
		return "Book [genre=" + genre + ", author=" + author + ", publication=" + publication + "]";
	}
	
}
