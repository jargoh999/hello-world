package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.Exceptions.PostDoesNotExistException;
import com.semicolon.africa.Blog.Exceptions.UserNotFoundException;
import com.semicolon.africa.Blog.data.model.Comment;
import com.semicolon.africa.Blog.data.model.Post;
import com.semicolon.africa.Blog.data.model.User;
import com.semicolon.africa.Blog.dtos.CommentRequest;
import com.semicolon.africa.Blog.dtos.CommentResponse;
import com.semicolon.africa.Blog.repository.Comments;
import com.semicolon.africa.Blog.repository.Posts;
import com.semicolon.africa.Blog.repository.Users;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.semicolon.africa.Blog.mappers.Mappers.*;

@Service
public class CommentServicesImpl implements CommentServices{
    @Autowired
    private Users users;
    @Autowired
    private Posts posts;
    @Autowired
    private Comments comments;
    @Override
    public CommentResponse commentToPost(CommentRequest commentRequest) {
        Comment comment = new Comment();
        User  userThatComment  = users.findUserByUserName(commentRequest.getCommenterUserName());
        Post post = posts.findPostByContent(commentRequest.getPostContent());
        User userThatOwnPost = users.findUserByUserName(post.getPosterUserName());
        comment.setCommenter(userThatComment);
        mapCommentRequestToComment(commentRequest,comment);
        comments.save(comment);
        post.setComments(comments.findCommentByContentCommentedOn(comment.getContentCommentedOn()));
        posts.save(post);
        userThatOwnPost.setPosts(posts.findPostByPosterUserName(userThatOwnPost.getUserName()));
        users.save(userThatOwnPost);
        return mapCommentRequestToResponse(commentRequest);
    }

    @Override
    public CommentResponse deleteCommentBy(CommentRequest commentRequest) {
        Post post = posts.findPostByContent(commentRequest.getPostContent());
        if(post == null)throw new PostDoesNotExistException("these post was not created");
        var user = users.findUserByUserName(post.getPosterUserName());
        Comment comment  = comments.findCommentByComment(commentRequest.getComment());
        if(!user.isLoggedIn())throw new UserNotFoundException("you are logged out");
        comments.deleteById(comment.getId());
        post.setComments(comments.findCommentByContentCommentedOn(post.getContent()));
        posts.save(post);
        user.setPosts(posts.findPostByPosterUserName(post.getPosterUserName()));
        users.save(user);
        return mapCommentRequestToResponse(commentRequest);
    }
}
