package com.dsfdfd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationScreenRepository extends JpaRepository<RegistrationScreen, Long> {

    void save(RegistrationScreen registrationScreen);

    RegistrationScreen findByUsername(String username);

    RegistrationScreen findByEmail(String email);

    RegistrationScreen findById(Long id);

    void deleteById(Long id);

    void deleteByUsername(String username);

    void deleteByEmail(String email);
}