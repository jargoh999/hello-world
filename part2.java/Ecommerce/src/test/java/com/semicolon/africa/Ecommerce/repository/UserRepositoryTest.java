package com.semicolon.africa.Ecommerce.repository;

import com.semicolon.africa.Ecommerce.data.models.Address;
import com.semicolon.africa.Ecommerce.data.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testThatUserRepoCanSave(){
        User user = new User();
        user.setUserName("ayo");
        Address address = new Address();
        address.setStreet("taye");
        address.setState("lagos");
        user.setAddress(address);
        userRepository.save(user);
        assertEquals(1L, userRepository.count());
    }


}