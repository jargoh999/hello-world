package com.semicolon.africa.passwordvault.utils;

import com.semicolon.africa.passwordvault.dto.*;
import com.semicolon.africa.passwordvault.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class Mappers {

    public static LogInResponse mapUserToResponse(User user){
                   LogInResponse logInResponse = new LogInResponse();
                   logInResponse.setUsersValuables(user.getValuablesInVaults());
                   logInResponse.setUsername(user.getMasterUserName());
                   logInResponse.setActive(user.isActive());
                   return logInResponse;
    }

    public static void mapRequestToUser(SignUpRequest signUpRequest, User user){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setMasterPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setMasterUserName(signUpRequest.getUsername());
    }

    public static SignUpResponse mapSignUpRequestToResponse(SignUpRequest signUpRequest) {
        SignUpResponse signUpResponse = new SignUpResponse();
        signUpResponse.setUsername(signUpRequest.getUsername());
        return signUpResponse;
    }



}
