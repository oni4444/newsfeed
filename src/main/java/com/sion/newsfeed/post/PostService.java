package com.sion.newsfeed.post;

import com.sion.newsfeed.post.dto.CreatePostRequestDto;
import com.sion.newsfeed.post.dto.CreatePostResponseDto;
import com.sion.newsfeed.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {

    // 속성
    private final PostRepository postRepository;


    // 생성자
    private PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    // 기능
    public CreatePostResponseDto createPostService(CreatePostRequestDto requestDto) {
        String title = requestDto.getTitle();
        String content = requestDto.getContent();

        // 검증로직

        // 엔티티 준비
        Post post = new Post(title, content);

        // 저장
        Post savedPost = postRepository.save(post);
        Long savedPostId = savedPost.getId();
        User user = savedPost.getUser();
        Long savedPostUserId = user.getId();
        String savedPostTitle = savedPost.getTitle();
        LocalDateTime savedPostCreatedAt = savedPost.getCreatedAt();

        // responseDto
        CreatePostResponseDto responseDto = new CreatePostResponseDto(savedPostId, savedPostUserId, savedPostTitle,savedPostCreatedAt, 201, "게시물이 작성되었어요!");
        return responseDto;

    }
}
