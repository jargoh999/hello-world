package com.semicolon.africa.Blog.repository;

import com.semicolon.africa.Blog.data.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Views extends MongoRepository<View,String> {
}
