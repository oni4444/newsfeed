package com.sion.newsfeed.comment;

import org.springframework.stereotype.Service;

@Service
public class CommentService {

    // 속성
    private final CommentRepository commentRepository;


    // 생성자
    private CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }



}
