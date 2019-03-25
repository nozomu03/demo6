package com.example.five.demo;

import java.util.List;

public class UserCommentPretocol {
    User user;
    List<Comment> comment;

    public UserCommentPretocol(User user, List<Comment> comment) {
        this.user = user;
        this.comment = comment;
    }
}
