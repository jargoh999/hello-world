package com.semicolon.africa.Ecommerce.controllers;
import com.semicolon.africa.Ecommerce.dto.BuyerRegisterRequest;
import com.semicolon.africa.Ecommerce.dto.RegisterRequest;
import com.semicolon.africa.Ecommerce.exceptions.E_commerceExceptions;
import com.semicolon.africa.Ecommerce.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/jargoh's-shop")
public class E_commerceControllers {
@Autowired
 private UserServicesImpl userServices;

@PostMapping("/sign-up")
  public ResponseEntity<?> signUp(@RequestBody RegisterRequest registerRequest){
       try {
          return new ResponseEntity<>(userServices.SignUp(registerRequest),CREATED);
       }catch (E_commerceExceptions exceptions){
           return new ResponseEntity<>(exceptions.getMessage(),BAD_REQUEST);
      }

}
    @PostMapping("/customer-sign-up")
    public ResponseEntity<?> signUp(@RequestBody BuyerRegisterRequest registerRequest){
        try {
            return new ResponseEntity<>(userServices.SignUp(registerRequest),CREATED);
        }catch (E_commerceExceptions exceptions){
            return new ResponseEntity<>(exceptions.getMessage(),BAD_REQUEST);
        }

    }


}
