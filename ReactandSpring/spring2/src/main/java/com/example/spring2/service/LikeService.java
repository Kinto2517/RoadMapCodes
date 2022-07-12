package com.example.spring2.service;

import com.example.spring2.entity.Like;
import com.example.spring2.request.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId);

    Like createOneLike(LikeCreateRequest request);

    Like getOneLikeById(Long likeId);

    void deleteOneLikeById(Long likeId);
}
