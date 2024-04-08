package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.dtos.*;
import com.semicolon.africa.Blog.repository.Comments;
import com.semicolon.africa.Blog.repository.Posts;
import com.semicolon.africa.Blog.repository.Users;
import com.semicolon.africa.Blog.repository.Views;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class CommentServicesImplTest {


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
    @Autowired
    private CommentServicesImpl commentServices;
    @Autowired
    private Comments comments;
    @Test
    public void testThatCommentAreSavedToPost() {
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
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setComment("okay");
        commentRequest.setPostContent("i am a boy");
        commentServices.commentToPost(commentRequest);
        assertEquals(posts.findPostByContent("i am a boy").getViews().size(), 1);
        assertEquals(posts.findPostByContent("i am a boy").getComments().size(),1 );
    }

    @Test
   public void testThatCommentCanBeDeleted() {
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
        comments.deleteAll();
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setComment("okay");
        commentRequest.setPostContent("i am a boy");
        commentServices.commentToPost(commentRequest);
        commentServices.deleteCommentBy(commentRequest);
        assertEquals(posts.findPostByContent("i am a boy").getViews().size(), 1);
        assertEquals(posts.findPostByContent("i am a boy").getComments().size(),0 );

   }
}