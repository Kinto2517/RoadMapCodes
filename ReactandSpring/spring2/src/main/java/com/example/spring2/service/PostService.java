package com.example.spring2.service;

import com.example.spring2.entity.Post;
import com.example.spring2.request.PostCreateRequest;
import com.example.spring2.request.PostUpdateRequest;
import com.example.spring2.response.PostResponse;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostResponse> getAllPosts(Optional<Long> userId);

    Post getPost(Long id);

    Post createPost(PostCreateRequest postreq);

    void deletePost(Long id);

    Post updatePost(Long id, PostUpdateRequest postUpdateRequest);
}
