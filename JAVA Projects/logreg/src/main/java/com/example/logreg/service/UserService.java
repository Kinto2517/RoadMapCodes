package com.example.logreg.service;

import com.example.logreg.model.User;
import com.example.logreg.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
