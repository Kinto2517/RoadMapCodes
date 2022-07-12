package com.example.spring2.service;

import com.example.spring2.entity.Comment;
import com.example.spring2.request.CommentCreateRequest;
import com.example.spring2.request.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId);

    Comment getComment(Long id);

    Comment createComment(CommentCreateRequest commentCreateRequest);

    void deleteComment(Long id);
    Comment updateComment(Long id, CommentUpdateRequest commentUpdateRequest);
}
