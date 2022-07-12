package com.example.spring2.service;

import com.example.spring2.entity.Like;
import com.example.spring2.entity.Post;
import com.example.spring2.entity.User;
import com.example.spring2.repository.LikeRepository;
import com.example.spring2.request.LikeCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {


    private LikeRepository likeRepository;
    private UserService userService;
    private PostService postService;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return likeRepository.findAllByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return likeRepository.findAllByUserId(userId.get());
        } else if (postId.isPresent()) {
            return likeRepository.findAllByPostId(postId.get());
        } else {
            return likeRepository.findAll();
        }
    }

    @Override
    public Like createOneLike(LikeCreateRequest request) {
        User user = userService.getUser(request.getUserId());
        Post post = postService.getPost(request.getPostId());
        if (user == null || post == null) {
            return null;
        }
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        return likeRepository.save(like);
    }

    @Override
    public Like getOneLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    @Override
    public void deleteOneLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
