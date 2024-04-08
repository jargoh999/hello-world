package com.semicolon.africa.real.task.repositories;


import com.semicolon.africa.real.task.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User,Long> {
    User findUsersByUserName(String userName);
}
