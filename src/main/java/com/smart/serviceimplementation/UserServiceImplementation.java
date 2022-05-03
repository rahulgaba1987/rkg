package com.smart.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.entities.User;
import com.smart.repository.UserRepository;
import com.smart.service.UserService;


@Service
public class UserServiceImplementation implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) 
	{
		
		return userRepository.save(user);
	}

}
