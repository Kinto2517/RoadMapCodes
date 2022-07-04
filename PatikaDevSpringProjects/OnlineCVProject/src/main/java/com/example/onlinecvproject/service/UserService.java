package com.example.onlinecvproject.service;

import com.example.onlinecvproject.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(User user);

    List<User> getAllUsers();

    User getByEmail(String email);

    void delete(Long id);

    User getById(Long id);

    List<User> searchBy(String search);

}
