package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="productId")
public class Apparal extends Product{
	
	
	private String type;
	private String brand;
	private String design;
	
	
	public Apparal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apparal(int productId, String productName, float price, String category) {
		super(productId, productName, price, category);
		// TODO Auto-generated constructor stub
	}

	public Apparal(int apparalId, String type, String brand, String design) {
		super();
		
		this.type = type;
		this.brand = brand;
		this.design = design;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	@Override
	public String toString() {
		return "Apparal [ type=" + type + ", brand=" + brand + ", design=" + design + "]";
	}
	
	
	
	
}