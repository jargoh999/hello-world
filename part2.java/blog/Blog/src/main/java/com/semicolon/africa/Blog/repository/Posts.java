package com.semicolon.africa.Blog.repository;


import com.semicolon.africa.Blog.data.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Posts extends MongoRepository<Post,String> {
      Post findPostByContent(String content);
      List<Post> findPostByTitle(String title);
      List<Post> findPostByPosterUserName(String username);
      void deletePostById(String id);
}
