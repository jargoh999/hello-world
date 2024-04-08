package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.dtos.LogInRequest;
import com.semicolon.africa.Blog.dtos.PostRequest;
import com.semicolon.africa.Blog.dtos.RegisterRequest;
import com.semicolon.africa.Blog.dtos.ViewRequest;
import com.semicolon.africa.Blog.repository.Posts;
import com.semicolon.africa.Blog.repository.Users;
import com.semicolon.africa.Blog.repository.Views;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ViewServicesImplTest {
    @Autowired
    private PostServices postServices;
    @Autowired
    private Posts posts;
    @Autowired
    private UserServicesImpl userServices;
    @Autowired
    private Users users;
    @Autowired
    private Views views;
    @Autowired
    private ViewServicesImpl viewServices;

    @Test
    public void testThatPostCanBeViewed() {
        users.deleteAll();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("ayo");
        registerRequest.setPassword("1234");
        registerRequest.setFirstName("ayomide");
        registerRequest.setLastName("dayo");
        userServices.signUp(registerRequest);
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUserName("ayo");
        logInRequest.setPassword("1234");
        userServices.logIn(logInRequest);
        posts.deleteAll();
        PostRequest postRequest = new PostRequest();
        postRequest.setPosterUserName("ayo");
        postRequest.setContent("i am a boy");
        postRequest.setTitle("semicolon is hard");
        postServices.createPost(postRequest);
        assertEquals(postServices.getAllPostsOf("ayo").size(), 1);
        ViewRequest viewRequest = new ViewRequest();
        viewRequest.setContentToView("i am a boy");
        viewServices.viewPosts(viewRequest);
        assertEquals(posts.findPostByContent("i am a boy").getViews().size(), 1);
    }
}