package com.sion.newsfeed.post.dto;

import java.time.LocalDateTime;

public class GetPostByIdResponseDto {

    private Long postId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;
    private String message;

    public GetPostByIdResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public GetPostByIdResponseDto(
            Long postId, Long userId, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, int status, String message
    ) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
        this.message = message;
    }
}
