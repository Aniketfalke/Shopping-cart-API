package com.mindtree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.User;
import com.mindtree.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public  User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

}
