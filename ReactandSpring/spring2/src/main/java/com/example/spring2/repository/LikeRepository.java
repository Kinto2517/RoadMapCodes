package com.example.spring2.repository;

import com.example.spring2.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findAllByPostId(Long aLong);

    List<Like> findAllByUserId(Long aLong);

    List<Like> findAllByUserIdAndPostId(Long aLong, Long aLong1);
}
