package com.example.undoubtedly.controller;


import com.example.undoubtedly.model.User;
import com.example.undoubtedly.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String showRegistrationForm(Model model) {
        logger.info("showRegistrationForm()");
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String processRegistrationForm(@ModelAttribute("user") User user, BindingResult bindingResult) {

        logger.info("processRegistrationForm()");
        if (bindingResult.hasErrors()) {
            logger.info("processRegistrationForm(): hasErrors");
            return "register";
        }
        logger.info("processRegistrationForm(): user: {}", user);
        userService.save(user);
        return "redirect:/login";

    }


}
