package com.sion.newsfeed.post.dto;

import java.time.LocalDateTime;

public class CreatePostResponseDto {

    // 속성
    private Long postId;
    private Long userId;
    private String title;
    private LocalDateTime createdAt;
    private int status;
    private String message;

    // 생성자
    public CreatePostResponseDto(Long postId, Long userId, String title, LocalDateTime createdAt, int status, String message) {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.createdAt = createdAt;
        this.status = status;
        this.message = message;
    }
}
