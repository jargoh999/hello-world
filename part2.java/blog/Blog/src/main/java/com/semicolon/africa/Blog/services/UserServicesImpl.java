package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.Exceptions.UserAlreadyExistException;
import com.semicolon.africa.Blog.Exceptions.UserNotFoundException;
import com.semicolon.africa.Blog.data.model.User;
import com.semicolon.africa.Blog.dtos.LogInRequest;
import com.semicolon.africa.Blog.dtos.LogInResponse;
import com.semicolon.africa.Blog.dtos.RegisterRequest;
import com.semicolon.africa.Blog.dtos.RegisterResponse;
import com.semicolon.africa.Blog.repository.Users;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.semicolon.africa.Blog.mappers.Mappers.*;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private Users users;

    @Override
    public RegisterResponse signUp(RegisterRequest registerRequest) {
        User user = new User();
        mapRequestToUser(registerRequest,user);
        if (isValid(user))users.save(user);
        else throw new UserAlreadyExistException("user already exist");
        return mapUserToRegisterResponse(user);
    }

    @Override
    public LogInResponse logIn(LogInRequest logInRequest) {
           LogInResponse logInResponse = new LogInResponse();
           var user = findUserByUserName(logInRequest.getUserName());
        if(user.getPassword().equalsIgnoreCase(logInRequest.getPassword())) user.setLoggedIn(true);
        else throw new UserNotFoundException("you are not a valid user !!");
        users.save(user);
        return mapLogInRequestToResponse(user,logInResponse);
    }

    private boolean isValid(User user) {

        return users.findUserByUserName(user.getUserName()) == null;
    }

    public User findUserByUserName(String userName)
    {return users.findUserByUserName(userName);}


    @Override
    public LogInResponse logOut(LogInRequest logInRequest) {
        LogInResponse logInResponse = new LogInResponse();
        var user = findUserByUserName(logInRequest.getUserName());
        if(user.isLoggedIn()) user.setLoggedIn(false);
        else throw new UserAlreadyExistException("you are logged out already");
        users.save(user);
        return mapLogInRequestToResponse(user,logInResponse);
    }



}