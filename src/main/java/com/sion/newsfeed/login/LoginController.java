package com.sion.newsfeed.login;

import com.sion.newsfeed.login.dto.LoginRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    // 속성
    private final LoginService loginService;


    // 생성자
    private LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // 기능
    public ResponseEntity<String> loginAPI(@RequestBody LoginRequestDto requestDto) {
        ResponseEntity<String> response = new ResponseEntity<>("로그인 완료", HttpStatus.OK);
        return response;
    }
}
