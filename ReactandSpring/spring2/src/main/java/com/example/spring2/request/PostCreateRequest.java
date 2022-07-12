package com.example.spring2.request;

import lombok.Data;

@Data
public class PostCreateRequest {

    private Long id;
    private String title;
    private String text;
    private Long userId;
}
