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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Apparal extends Product{
	
	
	private String type;
	private String brand;
	private String design;
	
}