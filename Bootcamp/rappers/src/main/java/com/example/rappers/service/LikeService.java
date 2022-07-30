package com.example.rappers.service;

import com.example.rappers.entity.Like;
import com.example.rappers.entity.Song;
import com.example.rappers.entity.User;
import com.example.rappers.repository.LikeRepository;
import com.example.rappers.request.LikeCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private LikeRepository likeRepository;

    private UserService userService;

    private SongService songService;

    @Autowired
    public LikeService(LikeRepository likeRepository, UserService userService, SongService songService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.songService = songService;
    }

    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    public Like getOneLike(Long id) {
        return likeRepository.findById(id).get();
    }

    public void deleteOneLike(Long id) {
        likeRepository.deleteById(id);
    }

    public Like createOneLike(LikeCreateRequest request) {
        User user = userService.getUser(request.getUserId());
        Song song = songService.getSong(request.getSongId());
        if (user == null || song == null) {
            return null;
        }
        Like like = new Like();
        like.setUser(user);
        like.setSong(song);
        return likeRepository.save(like);
    }

    public String getMostLiked() {
        Long number = likeRepository.findMostLiked();
        Like like = likeRepository.findById(2L).get();
        return like.getSong().getName() + " " + number;
    }
}
