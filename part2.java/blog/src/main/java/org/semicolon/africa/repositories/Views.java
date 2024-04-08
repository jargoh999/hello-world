package org.semicolon.africa.repositories;

import org.semicolon.africa.model.View;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Views extends MongoRepository<View,String> {
}
