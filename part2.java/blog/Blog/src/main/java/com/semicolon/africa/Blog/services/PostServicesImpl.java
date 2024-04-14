package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.Exceptions.PostDoesNotExistException;
import com.semicolon.africa.Blog.Exceptions.UserNotFoundException;
import com.semicolon.africa.Blog.data.model.Post;
import com.semicolon.africa.Blog.data.model.User;
import com.semicolon.africa.Blog.dtos.PostRequest;
import com.semicolon.africa.Blog.dtos.PostResponse;
import com.semicolon.africa.Blog.dtos.UpdatePostRequest;
import com.semicolon.africa.Blog.repository.Posts;
import com.semicolon.africa.Blog.repository.Users;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;


import static com.semicolon.africa.Blog.mappers.Mappers.*;

@Service
public class PostServicesImpl implements PostServices{
    @Autowired
    private Posts posts;

    @Autowired
    private Users users;

    public PostResponse createPost(PostRequest postRequest){
        Post post = new Post();
        postRequest.setTimeCreated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        var user = users.findUserByUserName(postRequest.getPosterUserName());
        if(user==null)throw new UserNotFoundException("you need to be a valid user to post");
        if(!user.isLoggedIn())throw new UserNotFoundException("you are logged out");
        mapRequestToPost(postRequest,post);
        user.getPosts().add(post);
        posts.save(post);
        users.save(user);
        return mapPostToResponse(post);
    }


    public List<Post> getAllPostsOf(String userName){
        if(users.findUserByUserName(userName) == null)throw new UserNotFoundException("you need to be a valid user to post");
        if(!users.findUserByUserName(userName).isLoggedIn())throw new UserNotFoundException("you are logged out");
        return getAllPostsFor(users.findUserByUserName(userName));
    }

    public List<Post> getAllPostsFor(User user){
        return user.getPosts();
    }

    @Override
    public PostResponse deletePostBy(PostRequest postRequest) {
         var user = users.findUserByUserName(postRequest.getPosterUserName());
         var post = posts.findPostByContent(postRequest.getContent());
         if(post == null)throw new PostDoesNotExistException("these post was not created");
         if(!user.isLoggedIn())throw new UserNotFoundException("you are logged out");
         posts.deletePostById(post.getId());
         posts.delete(post);
         user.setPosts(posts.findPostByPosterUserName(post.getPosterUserName()));
         users.save(user);
         return mapPostToResponse(post);
    }

    @Override
    public PostResponse updatePost(UpdatePostRequest updatePostRequest) {
                var post = posts.findPostById(updatePostRequest.getId());
                if(post==null)throw new PostDoesNotExistException("these post was not created");
                mapUpdateRequestToPost(updatePostRequest, post);
                posts.save(post);
                var user = users.findUserByUserName(updatePostRequest.getPosterUserName());
                if(!user.isLoggedIn())throw new UserNotFoundException("you are logged out");
                user.setPosts(posts.findPostByPosterUserName(updatePostRequest.getPosterUserName()));
                return mapPostToResponse(post);
    }

    @Override
    public List<Post> findAll() {
        return posts.findAll();
    }
}
