package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.data.model.User;
import com.semicolon.africa.Blog.dtos.*;

public interface UserServices {
    RegisterResponse signUp (RegisterRequest registerRequest);
    LogInResponse logIn(LogInRequest logInRequest);
    LogInResponse logOut(LogInRequest logInRequest);
    User findUserByUserName(String userName);
}
