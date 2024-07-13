package com.mindtree.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.MyCart;
import com.mindtree.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@Operation(summary = "Save cart")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = MyCart.class)) })})
	@PostMapping("/save/{id}")
	public ResponseEntity<MyCart> saveCart(@RequestBody MyCart cart, @PathVariable ("id") Integer userId) {
		MyCart cartDetails=cartService.saveCart(cart,userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(cartDetails);
	}
	@Operation(summary = "get cart detail by Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = MyCart.class)) })})
	@GetMapping("/get/{id}")
	public ResponseEntity<MyCart> getCartById(@PathVariable ("id")Integer cartId) {

		MyCart cartDetails=cartService.findByCartId(cartId);
		return ResponseEntity.ok(cartDetails);
	}
	

	
}
