package com.sion.newsfeed.user.dto;

public class CreateUserRequestDto {

    // 속성
    private String nickname;
    private String email;
    private String password;

    // 생성자



    // 기능
    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
