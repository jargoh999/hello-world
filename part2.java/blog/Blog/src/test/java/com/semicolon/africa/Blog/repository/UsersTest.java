package com.semicolon.africa.Blog.repository;
import com.semicolon.africa.Blog.Exceptions.UserAlreadyExistException;
import com.semicolon.africa.Blog.dtos.LogInRequest;
import com.semicolon.africa.Blog.dtos.RegisterRequest;
import com.semicolon.africa.Blog.services.UserServicesImpl;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class UsersTest {
        @Autowired
        private Users users;
        @Autowired
        private UserServicesImpl userServices;
        @Test
        public void UserRepositoryTest() {
            users.deleteAll();
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setUserName("ayo");
            registerRequest.setPassword("1234");
            registerRequest.setFirstName("ayomide");
            registerRequest.setLastName("dayo");
            userServices.signUp(registerRequest);
            assertEquals(1L, users.count());
            assertThat(users.count() ,is(1L));
        }
        @Test
        public void testThatRepoCantSaveSameUserTwice(){
            users.deleteAll();
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setUserName("ayo");
            registerRequest.setPassword("1234");
            registerRequest.setFirstName("ayomide");
            registerRequest.setLastName("dayo");
            userServices.signUp(registerRequest);
            assertEquals(1L, users.count());
            assertThat(users.count() ,is(1L));
           assertThrows(UserAlreadyExistException.class,()-> userServices.signUp(registerRequest));
            assertThat(users.count() ,is(1L));

        }

        @Test
        public void testThatWeCanFindUserByUserName(){
            var user = users.findUserByUserName("ayo");
            assertThat(users.findUserByUserName(user.getUserName()),is(user));
        }
       @Test
        public void testThatUserCanLogIn(){
           users.deleteAll();
           RegisterRequest registerRequest = new RegisterRequest();
           registerRequest.setUserName("ayo");
           registerRequest.setPassword("1234");
           registerRequest.setFirstName("ayomide");
           registerRequest.setLastName("dayo");
           userServices.signUp(registerRequest);
           LogInRequest logInRequest = new LogInRequest();
           logInRequest.setUserName("ayo");
           logInRequest.setPassword("1234");
           userServices.logIn(logInRequest);
           var user = users.findUserByUserName("ayo");
           assertTrue(user.isLoggedIn());
        }


        @Test
        public void testThatUserCanLogOut(){
            users.deleteAll();
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setUserName("ayo");
            registerRequest.setPassword("1234");
            registerRequest.setFirstName("ayomide");
            registerRequest.setLastName("dayo");
            userServices.signUp(registerRequest);
            LogInRequest logInRequest = new LogInRequest();
            logInRequest.setUserName("ayo");
            logInRequest.setPassword("1234");
            userServices.logIn(logInRequest);
            var user = users.findUserByUserName("ayo");
            assertTrue(user.isLoggedIn());
            userServices.logOut(logInRequest);
            var userAgain = users.findUserByUserName("ayo");
            assertFalse(userAgain.isLoggedIn());
        }

    }

