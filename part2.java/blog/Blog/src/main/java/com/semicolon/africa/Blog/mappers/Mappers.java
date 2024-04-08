package com.semicolon.africa.Blog.mappers;

import com.semicolon.africa.Blog.data.model.Comment;
import com.semicolon.africa.Blog.data.model.Post;
import com.semicolon.africa.Blog.data.model.User;
import com.semicolon.africa.Blog.dtos.*;
public class Mappers {


    public static void mapRequestToUser(RegisterRequest registerRequest, User user){
        user.setUserName(registerRequest.getUserName().toLowerCase());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(registerRequest.getPassword());
    }

    public static RegisterResponse mapUserToRegisterResponse(User user){
               RegisterResponse registerResponse = new RegisterResponse();
               registerResponse.setLastName(user.getLastName());
               registerResponse.setFirstName(user.getFirstName());
               return registerResponse;
    }

    public static LogInResponse mapLogInRequestToResponse(User user, LogInResponse logInResponse){
        logInResponse.setPosts(user.getPosts());
        logInResponse.setUserName(user.getUserName());
        return logInResponse;
    }


    public static PostResponse mapPostToResponse(Post post){
         PostResponse postResponse = new PostResponse();
         postResponse.setContent(post.getContent());
         postResponse.setTitle(post.getTitle());
         postResponse.setTimeCreated(post.getCreatedTime());
         postResponse.setPosterUserName(post.getPosterUserName());
         return postResponse;
    }

    public static void  mapRequestToPost(PostRequest postRequest,Post post){
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setPosterUserName(postRequest.getPosterUserName());
        post.setCreatedTime(postRequest.getTimeCreated());
    }


    public static  ViewResponse mapViewRequestToResponse(ViewRequest viewRequest){
        ViewResponse response = new ViewResponse();
        response.setContentViewed(viewRequest.getContentToView());
        response.setViewerUserName(viewRequest.getViewerUserName());
        response.setTimeOfView(viewRequest.getTimeOfView());
        return response;
    }

    public static void mapCommentRequestToComment(CommentRequest commentRequest, Comment comment){
        comment.setComment(commentRequest.getComment());
        comment.setContentCommentedOn(commentRequest.getPostContent());
    }

    public static CommentResponse mapCommentRequestToResponse(CommentRequest commentRequest){
           CommentResponse commentResponse = new CommentResponse();
           commentResponse.setComment(commentRequest.getComment());
           commentResponse.setCommenterUserName(commentRequest.getCommenterUserName());
           commentResponse.setPostContent(commentRequest.getPostContent());
           return commentResponse;
    }
}
