package com.example.humanresourcesproject.controller;

import com.example.humanresourcesproject.model.User;
import com.example.humanresourcesproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsersController {

     Logger logger = LoggerFactory.getLogger(UsersController.class);



    @Autowired
    private final UserService userService;

    public UsersController(UserService userService) {
        logger.info("UsersController constructor");
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){
        List<User> users = userService.getAllUsers();
        logger.info("UsersController: index: users: {}", users);
        model.addAttribute("users", users);

        return "index";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {

        List<User> users = userService.getAllUsers();
        logger.info("Users: {}", users);
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/users/add")
    public String addUser(Model model) {
        logger.info("addUser()");
        User user = new User();
        logger.info("user: " + user);
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
        logger.info("Adding user: " + user);
        if (result.hasErrors()) {
            logger.info("Error adding user: " + user);
            return "addUser";
        }
        logger.info("Saving user: " + user);
        userService.save(user);
        logger.info("Saved user: " + user);
        return "redirect:/users";
    }

    @PostMapping("/users/delete")
    public String delete(@RequestParam("id") Long id) {
        logger.debug("Deleting user with id: " + id);
        userService.delete(id);
        return "redirect:/users";
    }



}
