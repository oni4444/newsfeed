package com.sion.newsfeed.user;

import jakarta.persistence.*;

@Entity
public class User {

    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    // 생성자



    // 기능
    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
}
