package com.semicolon.africa.Ecommerce.services;
import com.semicolon.africa.Ecommerce.dto.BuyerRegisterRequest;
import com.semicolon.africa.Ecommerce.dto.RegisterRequest;
import com.semicolon.africa.Ecommerce.dto.RegisterResponse;

public interface UserServices {

     RegisterResponse SignUp(RegisterRequest registerRequest);

     RegisterResponse SignUp(BuyerRegisterRequest registerRequest);



}
