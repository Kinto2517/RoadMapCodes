package com.example.spring2.repository;

import com.example.spring2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostId(Long aLong);

    List<Comment> findAllByUserId(Long aLong);

    List<Comment> findAllByUserIdAndPostId(Long aLong, Long aLong1);
}
