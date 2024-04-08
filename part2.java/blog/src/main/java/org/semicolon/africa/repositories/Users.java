package org.semicolon.africa.repositories;

import org.semicolon.africa.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Users extends MongoRepository<User,String> {


}
