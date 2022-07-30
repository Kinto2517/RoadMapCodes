package com.example.rappers.repository;

import com.example.rappers.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}