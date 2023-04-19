package com.dsfdfd.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dsfdfd.model.RegistrationScreen;
import com.dsfdfd.model.User;
import com.dsfdfd.service.RegistrationScreenService;
import com.dsfdfd.service.LoginService;

@RestController
public class RegistrationController {
 
    @Autowired
    private RegistrationScreenService registrationScreenService;
 
    @Autowired
    private LoginService loginService;
 
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegistrationScreen registrationScreen) {
        User user = loginService.findByUsername(registrationScreen.getUsername());
        if (user != null) {
            return new ResponseEntity<>("Username already taken", HttpStatus.BAD_REQUEST);
        }
 
        user = loginService.findByEmail(registrationScreen.getEmail());
        if (user != null) {
            return new ResponseEntity<>("Email already taken", HttpStatus.BAD_REQUEST);
        }
 
        if (!registrationScreen.getPassword().equals(registrationScreen.getConfirmPassword())) {
            return new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST);
        }
 
        registrationScreenService.save(registrationScreen);
        return new ResponseEntity<>(registrationScreen, HttpStatus.CREATED);
    }
}