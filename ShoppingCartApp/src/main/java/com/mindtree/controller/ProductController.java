package com.mindtree.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Product;
import com.mindtree.repository.ProductRepo;
import com.mindtree.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@Operation(summary = "Get Product details by Id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = String.class)) })})
	@GetMapping("/get/id/{id}")
	public Product getProductById(@PathVariable ("id")Integer productId) {
		return productService.findByProductId(productId);
		
	}
	@Operation(summary = "Get Product by Name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = String.class)) })})
	@GetMapping("/get/name/{name}")
	public Product getProductByName(@PathVariable ("name") String productName) {
		return productService.findByProductName(productName);
	}
	@Operation(summary = "Get Product by category")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = String.class)) })})
	@GetMapping("/get/category/{category}")
	public Product getProductByCategory(@PathVariable("category") String category) {
		return productService.findByCategory(category);
	}

}
