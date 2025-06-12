package com.sion.newsfeed.post.dto;

import com.sion.newsfeed.post.Post;

import java.util.List;

public class GetPostsAllResponseDto {

    private List<Post> postList;
    private int status;
    private String message;

    public GetPostsAllResponseDto(List<Post> postList, int status, String message) {
        this.postList = postList;
        this.status = status;
        this.message = message;
    }
}
