package com.example.rappers.repository;

import com.example.rappers.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query("SELECT COUNT(l) FROM Like l WHERE l.song.id=2")
    Long findMostLiked();

}