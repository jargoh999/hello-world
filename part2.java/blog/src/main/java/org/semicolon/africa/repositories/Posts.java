package org.semicolon.africa.repositories;

import org.semicolon.africa.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Posts extends MongoRepository<Post,String> {
}
