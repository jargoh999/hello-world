package com.semicolon.africa.zoomlogistics.controllers;

import com.semicolon.africa.zoomlogistics.dto.AddressRequest;
import com.semicolon.africa.zoomlogistics.exceptions.LogisticsExceptions;
import com.semicolon.africa.zoomlogistics.services.AddressServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
public class AddressControllers{

    @Autowired
    private AddressServicesImpl addressServices;

    @PostMapping("/add-an-address")
    public ResponseEntity<?> addAddress(@RequestBody AddressRequest addressRequest){
                         try{
                             return new ResponseEntity<>(addressServices.addAddress(addressRequest),CREATED);
                         }catch (LogisticsExceptions exception){
                             return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);
                         }

    }
    @PatchMapping("/update-address/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("id") Long id, @RequestBody AddressRequest addressRequest){
        try{
            return new ResponseEntity<>(addressServices.updateAddress(id,addressRequest),OK);
        }catch (LogisticsExceptions exception){
            return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);
        }
    }

}
