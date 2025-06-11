package com.sion.newsfeed.user.dto;

public class GetUserResponseDto {

    // 속성
    private int status;
    private String message;
    private Long userId;
    private String nickname;
    private String email;

    // 생성자
    public GetUserResponseDto(int status, String message, Long userId, String nickname, String email) {
        this.status = status;
        this.message = message;
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
    }

    // 기능
    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
}
