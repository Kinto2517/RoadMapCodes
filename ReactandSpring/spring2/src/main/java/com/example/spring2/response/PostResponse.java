package com.example.spring2.response;

import com.example.spring2.entity.Post;
import lombok.Data;

@Data
public class PostResponse {

    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String text;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.userId = post.getUser().getId();
        this.userName = post.getUser().getUserName();
        this.title = post.getTitle();
        this.text = post.getText();
    }
}
