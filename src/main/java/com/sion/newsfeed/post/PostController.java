package com.sion.newsfeed.post;

import com.sion.newsfeed.post.dto.CreatePostRequestDto;
import com.sion.newsfeed.post.dto.CreatePostResponseDto;
import com.sion.newsfeed.post.dto.GetPostByIdResponseDto;
import com.sion.newsfeed.post.dto.GetPostsAllResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{postId}")
    public ResponseEntity<GetPostByIdResponseDto> getPostByIdAPI(@PathVariable Long postId) {
        GetPostByIdResponseDto responseDto = postService.getPostByIdService(postId);
        ResponseEntity<GetPostByIdResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    @GetMapping
    public ResponseEntity<GetPostsAllResponseDto> getAllPostsAPI() {
        GetPostsAllResponseDto responseDto = postService.getPostsAllService();
        ResponseEntity<GetPostsAllResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
        return response;
    }

    public ResponseEntity<String> updatePostAPI(@PathVariable Long postId, @RequestBody String title, String content) {
        ResponseEntity<String> response = new ResponseEntity<>("수정 완료", HttpStatus.OK);
        return response;
    }



}
