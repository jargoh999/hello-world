package com.semicolon.africa.Ecommerce.repository;

import com.semicolon.africa.Ecommerce.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
   User findUserByUserName(String username);
}
