package com.example.humanresourcesproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/login")
    public String login(){
        logger.info("login()");
        return "login";
    }


}
