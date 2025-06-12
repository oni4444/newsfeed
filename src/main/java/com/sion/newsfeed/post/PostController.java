package com.sion.newsfeed.post;

import com.sion.newsfeed.post.dto.CreatePostRequestDto;
import com.sion.newsfeed.post.dto.CreatePostResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    // 속성
    private final PostService postService;

    // 생성자
    private PostController(PostService postService) {
        this.postService = postService;
    }

    // 기능
    @PostMapping
    public ResponseEntity<CreatePostResponseDto> createPostAPI(CreatePostRequestDto requestDto) {
        CreatePostResponseDto responseDto = postService.createPostService(requestDto);
        ResponseEntity<CreatePostResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }



}
