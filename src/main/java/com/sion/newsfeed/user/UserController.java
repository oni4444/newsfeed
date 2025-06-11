package com.sion.newsfeed.user;

import com.sion.newsfeed.user.dto.GetUserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    // 속성
    private final UserService userService;



    // 생성자
    private UserController(UserService userService) {
        this.userService = userService;
    }



    // 기능
    @GetMapping("/{userId}")
    public ResponseEntity<GetUserResponseDto> getUserAPI(@PathVariable Long userId) {
        GetUserResponseDto responseDto = userService.getUserService(userId);
        ResponseEntity<GetUserResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

}
