package com.example.rabbitmqdemo.controller;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @PostMapping("/post")
    public String send(@RequestBody Message message) {
        rabbitTemplate.convertAndSend(directExchange.getName(), "queueA", message);
        return "Message sent";
    }

}
