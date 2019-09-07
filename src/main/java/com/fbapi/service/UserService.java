package com.fbapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbapi.model.User;
import com.fbapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public User add(User user) {
		return repository.save(user);
	}

	public List<User> getAll() {
		return repository.findAll();
	}

	public User getUserById(int userId) {
		Optional<User> user = repository.findById(userId);
		if(user.isPresent()) {
			return user.get();	
		}
		return null;
	}

	public void delete(int user_id) {
		repository.deleteById(user_id);
		
	}

}
