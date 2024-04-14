package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.data.model.Post;
import com.semicolon.africa.Blog.data.model.User;
import com.semicolon.africa.Blog.dtos.PostRequest;
import com.semicolon.africa.Blog.dtos.PostResponse;
import com.semicolon.africa.Blog.dtos.UpdatePostRequest;

import java.util.List;

public interface PostServices {
    PostResponse createPost(PostRequest postRequest);
    List<Post> getAllPostsOf(String userName);
    PostResponse deletePostBy(PostRequest postRequest);
    PostResponse updatePost(UpdatePostRequest updatePostRequest);
    List<Post> findAll();
}
