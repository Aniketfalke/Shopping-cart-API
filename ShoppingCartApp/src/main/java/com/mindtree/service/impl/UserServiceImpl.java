package com.mindtree.service.impl;

import com.mindtree.exception.UserNotCreatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mindtree.dao.UserDao;
import com.mindtree.entity.User;
import com.mindtree.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public  String saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User newUser=userDao.save(user);
		if(user!=null){
			return "User With "+newUser.getUserName()+" created successfully!";
		}
		throw new UserNotCreatedException("Error while creating the user");
	}

}
