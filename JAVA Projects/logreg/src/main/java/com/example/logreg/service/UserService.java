package com.example.logreg.service;

import com.example.logreg.model.User;
import com.example.logreg.web.dto.UserRegistrationDto;

public interface UserService {
    User save(UserRegistrationDto userRegistrationDto);
}
