package com.example.atmproject.service;

import com.example.atmproject.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(User user);

    List<User> getAllUsers();
}
