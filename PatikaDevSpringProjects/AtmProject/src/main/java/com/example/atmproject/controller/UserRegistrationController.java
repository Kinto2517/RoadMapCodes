package com.example.atmproject.controller;


import com.example.atmproject.model.User;
import com.example.atmproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    private UserService userService;


    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String processRegistrationForm(@ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.save(user);
        return "redirect:/login";

    }


}
