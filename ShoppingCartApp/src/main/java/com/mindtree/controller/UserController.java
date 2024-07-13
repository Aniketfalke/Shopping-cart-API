package com.mindtree.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.User;
import com.mindtree.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@Operation(summary = "Delete all product from the cart")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = String.class)) })})
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User userResponse =userService.saveUser(user);
		return ResponseEntity.ok(userResponse);
		
	}
	
}
