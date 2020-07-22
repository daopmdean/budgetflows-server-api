package com.budgetflows.springserverapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budgetflows.springserverapi.controller.util.AppException;
import com.budgetflows.springserverapi.entity.User;
import com.budgetflows.springserverapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User login(String email, String password) throws AppException {
		User existUser = repo.findByEmail(email);

		if (existUser == null) {
			throw new AppException("User email not found");
		}

		if (password.equals(existUser.getPassword())) {
			return existUser;
		}

		throw new AppException("Incorrect password");
	}

	public User getUser(String email) throws AppException {
		User user = repo.findByEmail(email);
		if (user == null) {
			throw new AppException("Email does not exist");
		}
		return user;
	}

	public boolean existUser(String email) {
		try {
			getUser(email);
			return true;
		} catch (AppException e) {
			return false;
		}
	}

	public User register(User user) throws AppException {
		try {
			if (existUser(user.getEmail())) {
				throw new AppException("Email already exist");
			}
			return repo.save(user);
		} catch (Exception e) {
			throw new AppException("Email already exist");
		}
	}
	
	
}
