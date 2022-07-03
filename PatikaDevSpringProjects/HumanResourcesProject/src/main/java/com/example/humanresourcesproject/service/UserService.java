package com.example.humanresourcesproject.service;

import com.example.humanresourcesproject.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(User user);

    List<User> getAllUsers();

    User getByEmail(String email);

    void delete(Long id);
}
