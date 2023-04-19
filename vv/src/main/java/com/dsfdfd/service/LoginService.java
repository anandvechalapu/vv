package com.dsfdfd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsfdfd.login.User;
import com.dsfdfd.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public User findByUsername(String username) {
		return loginRepository.findByUsername(username);
	}

	public User findByEmail(String email) {
		return loginRepository.findByEmail(email);
	}

	public boolean existsByUsername(String username) {
		return loginRepository.existsByUsername(username);
	}

	public boolean existsByEmail(String email) {
		return loginRepository.existsByEmail(email);
	}

}