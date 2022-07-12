package com.example.spring2.request;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private String text;
    private Long postId;
    private Long userId;
}
