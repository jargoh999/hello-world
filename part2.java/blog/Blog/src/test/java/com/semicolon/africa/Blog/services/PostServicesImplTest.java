package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.data.model.User;
import com.semicolon.africa.Blog.dtos.LogInRequest;
import com.semicolon.africa.Blog.dtos.PostRequest;
import com.semicolon.africa.Blog.dtos.RegisterRequest;
import com.semicolon.africa.Blog.repository.Posts;
import com.semicolon.africa.Blog.repository.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class PostServicesImplTest {

    @Autowired
    private PostServices postServices;
    @Autowired
    private Posts posts;
    @Autowired
    private UserServicesImpl userServices;
    @Autowired
    private Users users;
    @Test
    public void testThatPostCAnBeCreated() {
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
        PostRequest postRequest = new PostRequest();
        postRequest.setPosterUserName("ayo");
        postRequest.setContent("i am a boy");
        postRequest.setTitle("semicolon is hard");
        postServices.createPost(postRequest);
        assertEquals(postServices.getAllPostsOf("ayo").size(),1);

    }

    @Test
    public void testThatWeCanGetAllUserPost() {
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
        assertEquals(postServices.getAllPostsOf("ayo").size(),1);
    }

    @Test
    public void testGetAllPostsForUser() {
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
        postRequest.setContent("i am a  good boy");
        postRequest.setTitle("semicolon is hard");
        postServices.createPost(postRequest);
        assertEquals(postServices.getAllPostsOf("ayo").size(),1);
    }

    @Test
    public void testDeletePostBy() {
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
        postServices.deletePostBy(postRequest);
        assertEquals(postServices.getAllPostsOf("ayo").size(),0);

    }
}