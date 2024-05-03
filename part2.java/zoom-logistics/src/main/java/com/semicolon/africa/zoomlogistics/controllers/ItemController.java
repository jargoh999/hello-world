package com.semicolon.africa.zoomlogistics.controllers;

import com.semicolon.africa.zoomlogistics.dto.AddressRequest;
import com.semicolon.africa.zoomlogistics.dto.ItemRequest;
import com.semicolon.africa.zoomlogistics.exceptions.LogisticsExceptions;
import com.semicolon.africa.zoomlogistics.services.ItemServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
@RestController
@AllArgsConstructor
public class ItemController {
    @Autowired
    private ItemServicesImpl itemServices;
    @PostMapping("/add-an-item")
    public ResponseEntity<?> addAddress(@RequestBody ItemRequest itemRequest){
        try{
            return new ResponseEntity<>(itemServices.addItem(itemRequest),CREATED);
        }catch (LogisticsExceptions exception){
            return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);

        }

    }
    @PatchMapping("/update-item/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("id") Long id, @RequestBody ItemRequest itemRequest){
        try{
            return new ResponseEntity<>(itemServices.updateItem(id,itemRequest),OK);
        }catch (LogisticsExceptions exception){
            return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);

        }

    }

    @DeleteMapping("/delete-item/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("id") Long id){
        try{
            return new ResponseEntity<>(itemServices.deleteItem(id),OK);
        }catch (LogisticsExceptions exception){
            return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);

        }

    }
}
