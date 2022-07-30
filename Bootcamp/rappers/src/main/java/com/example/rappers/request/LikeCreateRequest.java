package com.example.rappers.request;


import lombok.Data;

@Data
public class LikeCreateRequest {

    private Long songId;
    private Long userId;
}