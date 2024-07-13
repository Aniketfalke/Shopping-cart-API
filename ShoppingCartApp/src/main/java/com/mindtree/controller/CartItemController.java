package com.mindtree.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.CartItem;
import com.mindtree.entity.MyCart;
import com.mindtree.service.CartItemService;
import com.mindtree.service.CartService;
import com.mindtree.service.UserService;

@RestController

public class CartItemController {
	
	@Autowired
	private CartItemService cartItemService;

	@Operation(summary = "add cart details ")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = CartItem.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad request",
					content = @Content)
	})
	@PostMapping("cart/{cartId}/product/{productId}/add")
	public CartItem saveCartItem(@RequestBody CartItem cartIteam,@PathVariable Integer cartId,@PathVariable("productId") Integer productId) {
		
		return cartItemService.saveCartItem(cartIteam,cartId,productId);
		
	}
	@Operation(summary = "Delete specific product from the cart")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = String.class)) })})
	@DeleteMapping("/cart/delete/{id}")
	public String deleteProductFromCart(@PathVariable("id") Integer productId) {
		
		return cartItemService.deleteProductFromCartItem(productId);
	}
	@Operation(summary = "Delete all product from the cart")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = String.class)) })})
	@DeleteMapping("/cart/delete/all/{cartId}")
	public String deleteAllProductFromCart(@PathVariable Integer cartId) {
		return cartItemService.deleteAllProductFromCartItem(cartId);
		
	}

	@Operation(summary = "Update product in cart")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = String.class)) })})
	@PutMapping("/cart/update/{cartId}/product/{id}")
	public String updateProductQuantity(@RequestBody CartItem cartItem, @PathVariable ("id") Integer ProductId,
			@PathVariable ("cartId")Integer cartId) {
		return cartItemService.updateProductQuantity(cartItem,cartId,ProductId);
	}
	
}
