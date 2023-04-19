package com.dsfdfd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsfdfd.repository.RegistrationScreenRepository;
import com.dsfdfd.entity.RegistrationScreen;

@Service
public class RegistrationScreenService {
    
    @Autowired
    private RegistrationScreenRepository registrationScreenRepository;
    
    public void save(RegistrationScreen registrationScreen) {
        registrationScreenRepository.save(registrationScreen);
    }

    public RegistrationScreen findByUsername(String username) {
        return registrationScreenRepository.findByUsername(username);
    }

    public RegistrationScreen findByEmail(String email) {
        return registrationScreenRepository.findByEmail(email);
    }

    public RegistrationScreen findById(Long id) {
        return registrationScreenRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        registrationScreenRepository.deleteById(id);
    }

    public void deleteByUsername(String username) {
        registrationScreenRepository.deleteByUsername(username);
    }

    public void deleteByEmail(String email) {
        registrationScreenRepository.deleteByEmail(email);
    }
}