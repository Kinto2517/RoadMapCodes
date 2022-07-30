package com.example.rappers.controller;

import com.example.rappers.entity.Like;
import com.example.rappers.request.LikeCreateRequest;
import com.example.rappers.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.getAllLikes();
    }

    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest request) {
        return likeService.createOneLike(request);
    }

    @DeleteMapping("/{id}")
    public void deleteOneLike(@PathVariable Long id) {
        likeService.deleteOneLike(id);
    }

    @GetMapping("/{id}")
    public Like getOneLike(@PathVariable Long id) {
        return likeService.getOneLike(id);
    }

    @GetMapping("/mostliked")
    public String getMostLiked() {
        return likeService.getMostLiked();
    }

}
