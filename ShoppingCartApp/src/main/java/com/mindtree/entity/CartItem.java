package com.mindtree.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartItem {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer cartIteamId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cart_id",referencedColumnName = "cartId")
	@JsonBackReference
    private MyCart cart;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="product_id",referencedColumnName = "productId")
	private Product product;
	
	private int quantity;
	
	@Transient
	private float subPrice;

}
