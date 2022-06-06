package com.example.springboot.tuto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ThymeController {


    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/thyme1")
    public String getThymeleaf1(){
        return "thyme1";
    }

    @GetMapping("/thyme2model")
    public String getThymeleaf2Model(Model model){
        model.addAttribute("key_model","attrdan geldim");

        return "thyme1";
    }


    //   8080:/thyme4/63
    // RequestParam  8080:/thyme4?id=63   @RequestParam(name = "id", required = false, defaultValue="0" Long id,
    // RequestParam(name = "isim")
    @GetMapping({"/thyme4/{id}","/thyme4"})
    public String getThymeleaf4(Model model, @PathVariable(name = "id", required = false) Long id){

        if(id!=null){
            model.addAttribute("keyid", "id: "+id);
        }else{
            model.addAttribute("keyid", "id bulunamadı");
        }

        return "thyme4";
    }


}
