package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.data.model.View;
import com.semicolon.africa.Blog.dtos.ViewRequest;
import com.semicolon.africa.Blog.dtos.ViewResponse;
import com.semicolon.africa.Blog.repository.Posts;
import com.semicolon.africa.Blog.repository.Users;
import com.semicolon.africa.Blog.repository.Views;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.semicolon.africa.Blog.mappers.Mappers.mapViewRequestToResponse;

@Service
public class ViewServicesImpl implements ViewServices{

    @Autowired
    private Views views;

    @Autowired
     private Posts posts;

    @Autowired
    private Users users;

    public ViewResponse viewPosts(ViewRequest viewRequest){
        View view = new View();
        viewRequest.setTimeOfView(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        var post = posts.findPostByContent(viewRequest.getContentToView());
        view.setViewer(users.findUserByUserName(viewRequest.getViewerUserName()));
        view.setTimeOfView(viewRequest.getTimeOfView());
        views.save(view);
        post.getViews().add(view);
        posts.save(post);
        var user = users.findUserByUserName(post.getPosterUserName());
        user.setPosts(posts.findPostByPosterUserName(post.getPosterUserName()));
        users.save(user);
        return mapViewRequestToResponse(viewRequest);
    }
}
