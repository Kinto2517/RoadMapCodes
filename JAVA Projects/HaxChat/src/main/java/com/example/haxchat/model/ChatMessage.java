package com.example.haxchat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {

    private String content;
    private String sender;
    private MessageType messageType;


    public enum MessageType{
        CHAT,LEAVE,JOIN
    }
}
