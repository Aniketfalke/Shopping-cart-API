package com.mindtree.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="productId")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book  extends Product{
  
	
	private String genre;
	private String author;
	private String publication;

}
