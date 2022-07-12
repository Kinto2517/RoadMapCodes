package com.example.spring2.request;

import lombok.Data;

@Data
public class LikeCreateRequest {
    private Long postId;
    private Long userId;
}
