package com.sion.newsfeed.like;

import com.sion.newsfeed.post.Post;
import com.sion.newsfeed.user.User;
import jakarta.persistence.*;

@Entity
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
