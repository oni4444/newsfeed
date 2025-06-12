package com.sion.newsfeed.login;

import com.sion.newsfeed.login.dto.LoginRequestDto;
import com.sion.newsfeed.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    // 속성
    private final UserRepository userRepository;

    // 생성자
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 기능
    public void loginService(LoginRequestDto requestDto) {
        userRepository.findBy()
    }

}
