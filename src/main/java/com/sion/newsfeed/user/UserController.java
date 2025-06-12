package com.sion.newsfeed.user;

import com.sion.newsfeed.user.dto.GetUserResponseDto;
import com.sion.newsfeed.user.dto.UpdateUserRequestDto;
import com.sion.newsfeed.user.dto.UpdateUserResponseDto;
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
    @PostMapping
    public ResponseEntity<String> createUserAPI(@RequestBody String nickname, String email, String password) {
        ResponseEntity<String> response = new ResponseEntity<>("가입 완료", HttpStatus.OK);
        return response;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserResponseDto> getUserAPI(@PathVariable Long userId) {
        GetUserResponseDto responseDto = userService.getUserService(userId);
        ResponseEntity<GetUserResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UpdateUserResponseDto> updateUserAPI(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequestDto requestDto
    ) {
        UpdateUserResponseDto responseDto = userService.updateUserService(userId, requestDto);
        ResponseEntity<UpdateUserResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

}
