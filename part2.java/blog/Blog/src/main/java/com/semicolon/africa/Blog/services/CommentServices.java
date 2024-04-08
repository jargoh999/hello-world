package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.data.model.Comment;
import com.semicolon.africa.Blog.data.model.Post;
import com.semicolon.africa.Blog.data.model.User;
import com.semicolon.africa.Blog.dtos.CommentRequest;
import com.semicolon.africa.Blog.dtos.CommentResponse;
import com.semicolon.africa.Blog.dtos.PostRequest;
import com.semicolon.africa.Blog.dtos.PostResponse;

import java.util.List;

public interface CommentServices {
    CommentResponse commentToPost(CommentRequest commentRequest);
    CommentResponse deleteCommentBy(CommentRequest commentRequest);
}
