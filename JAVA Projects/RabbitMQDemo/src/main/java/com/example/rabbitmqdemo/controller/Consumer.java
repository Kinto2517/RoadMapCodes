package com.example.rabbitmqdemo.controller;

import com.example.rabbitmqdemo.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = "queueA")
    public void receiveMessage(Message message) {
        log.info("Received message: {}", message);
    }

    @RabbitListener(queues = "queueB")
    public void receiveMessage2(Message message) {
        log.info("Received message: {}", message);
    }

}
