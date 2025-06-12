package com.sion.newsfeed.comment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    // 속성
    private final CommentService commentService;


    // 생성자
    private CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 기능
    public void createCommentAPI() {}

}
