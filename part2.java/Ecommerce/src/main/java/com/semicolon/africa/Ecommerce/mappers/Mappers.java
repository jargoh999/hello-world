package com.semicolon.africa.Ecommerce.mappers;

import com.semicolon.africa.Ecommerce.data.models.*;
import com.semicolon.africa.Ecommerce.dto.BuyerRegisterRequest;
import com.semicolon.africa.Ecommerce.dto.RegisterRequest;
import com.semicolon.africa.Ecommerce.dto.RegisterResponse;

public class Mappers {

    public static RegisterResponse mapRegisterRequestToResponse(RegisterRequest registerRequest){
                  RegisterResponse registerResponse = new RegisterResponse();
                  registerResponse.setUserName(registerRequest.getUserName());
                  registerResponse.setPhoneNumber(registerRequest.getPhoneNumber());
                  registerResponse.setEmailAddress(registerRequest.getEmailAddress());
                  return registerResponse;
    }

    public static RegisterResponse mapRegisterRequestToResponse(BuyerRegisterRequest registerRequest){
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUserName(registerRequest.getUserName());
        registerResponse.setPhoneNumber(registerRequest.getPhoneNumber());
        registerResponse.setEmailAddress(registerRequest.getEmailAddress());
        return registerResponse;
    }


    public static void mapRequestToSeller(RegisterRequest registerRequest, Seller seller){
        seller.setAge(registerRequest.getAge());
        seller.setAddress(registerRequest.getAddress());
        seller.setUserName(registerRequest.getUserName());
        seller.setUserRole(Role.valueOf(registerRequest.getRole()));
        seller.setEmailAddress(registerRequest.getEmailAddress());
        seller.setPhoneNumber(registerRequest.getPhoneNumber());
    }


    public static void mapRequestToBuyer(BuyerRegisterRequest registerRequest, Buyer buyer){
        buyer.setAge(registerRequest.getAge());
        buyer.setAddress(registerRequest.getAddress());
        buyer.setUserName(registerRequest.getUserName());
        buyer.setUserRole(Role.valueOf(registerRequest.getRole()));
        buyer.setEmailAddress(registerRequest.getEmailAddress());
        buyer.setPhoneNumber(registerRequest.getPhoneNumber());
        buyer.setBillingInformation(registerRequest.getBillingInformation());
        buyer.setPassWord(registerRequest.getPassWord());
    }
}
