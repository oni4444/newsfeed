package com.sion.newsfeed.user.dto;

public class UpdateUserResponseDto {

    // 속성
    private int status;
    private String message;
    private Long userId;
    private String nickname;

    // 생성자
    public UpdateUserResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // 기능
}
