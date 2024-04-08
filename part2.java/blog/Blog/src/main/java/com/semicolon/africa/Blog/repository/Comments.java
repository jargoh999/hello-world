package com.semicolon.africa.Blog.repository;
import com.semicolon.africa.Blog.data.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Comments extends MongoRepository<Comment,String> {
    List<Comment> findCommentByContentCommentedOn(String contentCommentedOn);
    Comment findCommentByComment(String comment);
}
