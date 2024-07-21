package com.mindtree.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyCart {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
     @OneToOne(cascade =CascadeType.PERSIST)
     private User user;
    
     @OneToMany(mappedBy = "cart")
    @JsonManagedReference
     private List<CartItem> cartIteam;
     
     @Transient
     private float totalPrice;

	
}
