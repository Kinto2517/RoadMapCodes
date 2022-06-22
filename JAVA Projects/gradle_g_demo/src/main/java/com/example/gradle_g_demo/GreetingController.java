package com.example.gradle_g_demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String greeting(@RequestParam(value = "xyz") String xyz){
        return "Hello World xyz" + xyz;
    }

    @PostMapping("/")
    public String post(@RequestBody String xyz){
        return "Hello World"+ xyz;
    }

}
