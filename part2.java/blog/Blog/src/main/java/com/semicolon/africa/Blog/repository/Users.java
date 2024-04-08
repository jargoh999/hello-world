package com.semicolon.africa.Blog.repository;


import com.semicolon.africa.Blog.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

public interface Users extends MongoRepository<User,String> {
    User findUserByUserName(String userName);
}
