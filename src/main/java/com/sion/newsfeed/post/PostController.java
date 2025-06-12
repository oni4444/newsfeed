package com.sion.newsfeed.post;

import com.sion.newsfeed.post.dto.CreatePostRequestDto;
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
    public ResponseEntity<String> createPostAPI(CreatePostRequestDto requestDto) {
        ResponseEntity<String> response = new ResponseEntity<>("게시물 생성 완료", HttpStatus.OK);
        return response;
    }



}
