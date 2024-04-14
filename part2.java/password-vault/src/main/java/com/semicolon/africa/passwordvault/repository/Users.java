package com.semicolon.africa.passwordvault.repository;

import com.semicolon.africa.passwordvault.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Users extends JpaRepository<User,Long> {
User findUsersByMasterUserName(String masterUserName);
}
