package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private float price;
	private String category;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, float price,String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.category=category;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", category="
				+ category + "]";
	}
	
     
}
