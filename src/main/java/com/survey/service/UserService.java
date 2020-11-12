package com.survey.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.survey.dto.UserRegistrationDto;
import com.survey.model.User;


public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
