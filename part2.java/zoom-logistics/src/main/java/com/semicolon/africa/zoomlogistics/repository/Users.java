package com.semicolon.africa.zoomlogistics.repository;

import com.semicolon.africa.zoomlogistics.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User,Long> {
    User findUserById(Long id);
    User findUsersByEmail(String email);
    User findUsersByUsername(String username);
}
