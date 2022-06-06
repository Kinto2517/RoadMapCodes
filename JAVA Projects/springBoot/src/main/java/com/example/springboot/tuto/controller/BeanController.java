package com.example.springboot.tuto.controller;


import com.example.springboot.tuto.bean.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BeanController {

        @Autowired
        BeanConfig beanConfig;

        @GetMapping("/bean")
        @ResponseBody
        public String getBeanDto(){
            return beanConfig.beanDto()+"";
        }



}
