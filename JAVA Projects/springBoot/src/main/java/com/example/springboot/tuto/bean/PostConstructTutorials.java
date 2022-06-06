package com.example.springboot.tuto.bean;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

public class PostConstructTutorials {

    @Autowired
    Logger LOG;

    @PostConstruct
    public void init(){
        LOG.info("heyy");
    }

    public static void main(String[] args) {
        PostConstructTutorials beanController = new PostConstructTutorials();
        System.out.println(beanController);
    }
}
