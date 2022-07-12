package com.example.spring2.service;

import com.example.spring2.entity.Comment;
import com.example.spring2.entity.Post;
import com.example.spring2.entity.User;
import com.example.spring2.repository.CommentRepository;
import com.example.spring2.request.CommentCreateRequest;
import com.example.spring2.request.CommentUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    private UserService userService;

    private PostService postService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findAllByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findAllByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findAllByPostId(postId.get());
        } else {
            return commentRepository.findAll();
        }
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment createComment(CommentCreateRequest commentCreateRequest) {
        Post post = postService.getPost(commentCreateRequest.getPostId());
        User user = userService.getUser(commentCreateRequest.getUserId());
        if (post == null || user == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUser(user);
        comment.setText(commentCreateRequest.getText());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment updateComment(Long id, CommentUpdateRequest commentUpdateRequest) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if (comment == null) {
            return null;
        }
        comment.setText(commentUpdateRequest.getText());
        return commentRepository.save(comment);
    }
}
