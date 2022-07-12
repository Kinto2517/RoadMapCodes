package com.example.spring2.service;

import com.example.spring2.entity.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    User createUser(User user);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}
