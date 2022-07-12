package com.example.spring2.controller;

import com.example.spring2.entity.Post;
import com.example.spring2.repository.PostRepository;
import com.example.spring2.request.PostCreateRequest;
import com.example.spring2.request.PostUpdateRequest;
import com.example.spring2.response.PostResponse;
import com.example.spring2.service.PostService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    @PostMapping
    public Post createPost(@RequestBody PostCreateRequest postreq) {
        return postService.createPost(postreq);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest postUpdateRequest) {
        return postService.updatePost(id, postUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }



}
