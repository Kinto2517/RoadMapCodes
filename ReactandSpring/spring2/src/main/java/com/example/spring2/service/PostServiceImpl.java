package com.example.spring2.service;

import com.example.spring2.entity.Post;
import com.example.spring2.entity.User;
import com.example.spring2.repository.PostRepository;
import com.example.spring2.request.PostCreateRequest;
import com.example.spring2.request.PostUpdateRequest;
import com.example.spring2.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private UserService userService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }


    @Override
    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> posts;
        if (userId.isPresent()) {
            posts = postRepository.findAllByUserId(userId.get());
        }
        posts = postRepository.findAll();
        return posts.stream().map(post -> new PostResponse(post)).collect(Collectors.toList());
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post createPost(PostCreateRequest postreq) {
        User user = userService.getUser(postreq.getUserId());
        if (user == null) {
            return null;
        }
        Post post = new Post();
        post.setUser(user);
        post.setTitle(postreq.getTitle());
        post.setText(postreq.getText());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Long id, PostUpdateRequest postUpdateRequest) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            return null;
        }
        post.setTitle(postUpdateRequest.getTitle());
        post.setText(postUpdateRequest.getText());
        return postRepository.save(post);
    }
}
