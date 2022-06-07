package com.example.reacthaxchat.controller.model;

import lombok.*;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Message {

    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;


}
