package com.sion.newsfeed.post;

import com.sion.newsfeed.post.dto.CreatePostRequestDto;
import com.sion.newsfeed.post.dto.CreatePostResponseDto;
import com.sion.newsfeed.post.dto.GetPostByIdResponseDto;
import com.sion.newsfeed.post.dto.GetPostsAllResponseDto;
import com.sion.newsfeed.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        if (title == null || title.trim().isEmpty()) {
            CreatePostResponseDto responseDto = new CreatePostResponseDto(null, null, null, null, 400, "제목을 입력해 주세요!");
            return responseDto;
        }

        if (content == null || content.trim().isEmpty()) {
            CreatePostResponseDto responseDto = new CreatePostResponseDto(null, null, null, null, 400, "내용을 입력해 주세요!");
            return responseDto;
        }

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
        CreatePostResponseDto responseDto = new CreatePostResponseDto(savedPostId, savedPostUserId, savedPostTitle, savedPostCreatedAt, 201, "게시물이 작성되었어요!");
        return responseDto;

    }

    public GetPostByIdResponseDto getPostByIdService(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            User postUser = post.getUser();
            Long postUserId = postUser.getId();
            String postTitle = post.getTitle();
            String postContent = post.getContent();
            LocalDateTime postCreatedAt = post.getCreatedAt();
            LocalDateTime postUpdatedAt = post.getUpdatedAt();

            GetPostByIdResponseDto responseDto = new GetPostByIdResponseDto(
                    postId, postUserId, postTitle, postContent, postCreatedAt, postUpdatedAt, 200, "게시물 조회가 완료되었습니다."
            );
            return responseDto;
        } else {
            GetPostByIdResponseDto responseDto = new GetPostByIdResponseDto(400, "존재하지 않는 게시물입니다.");
            return responseDto;
        }
    }

    public GetPostsAllResponseDto getPostsAllService() {
        List<Post> postList = postRepository.findAll();
        GetPostsAllResponseDto responseDto = new GetPostsAllResponseDto(postList, 200, "게시물 조회가 완료됐어요!" );
        return responseDto;
    }

    public void updatePostService(Long postId, String title, String content) {
        Optional<Post> postOptional = postRepository.findById(postId);
        Post post = postOptional.get();
        post.updateTitle(title);
        post.updateContent(content);

    }

}
