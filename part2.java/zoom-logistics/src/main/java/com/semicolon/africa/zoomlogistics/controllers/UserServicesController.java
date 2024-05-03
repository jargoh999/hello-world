package com.semicolon.africa.zoomlogistics.controllers;
import com.semicolon.africa.zoomlogistics.dto.LoginRequest;
import com.semicolon.africa.zoomlogistics.dto.OrderRequest;
import com.semicolon.africa.zoomlogistics.dto.SignUpRequest;
import com.semicolon.africa.zoomlogistics.exceptions.LogisticsExceptions;
import com.semicolon.africa.zoomlogistics.services.LogisticAgentServicesImpl;
import com.semicolon.africa.zoomlogistics.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
public class UserServicesController {
    @Autowired
    private UserServicesImpl userServices;
    @Autowired
    private LogisticAgentServicesImpl logisticAgent;

    @PostMapping("/users/sign-up")
    public ResponseEntity<?> signUp (@RequestBody SignUpRequest signUpRequest){
                  try{
                       return new ResponseEntity<>(userServices.signUp(signUpRequest), OK);
                  }catch (LogisticsExceptions exceptions) {
                      return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
                  }
    }

    @PostMapping("/users/log-in")
    public ResponseEntity<?> logIn (@RequestBody LoginRequest loginRequest){
        try{
            return new ResponseEntity<>(userServices.logIn(loginRequest), OK);
        }catch (LogisticsExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/users/log-out")
    public ResponseEntity<?> logOut(@RequestBody LoginRequest loginRequest){
        try{
            return new ResponseEntity<>(userServices.logOut(loginRequest), OK);
        }catch (LogisticsExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/place-order")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest orderRequest){
        try{
            return new ResponseEntity<>(userServices.placeOrder(orderRequest), OK);
        }catch (LogisticsExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }

    }
    @DeleteMapping("/cancel-order/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable("orderId") UUID orderId){
        try{
            return new ResponseEntity<>(userServices.CancelOrder(orderId), OK);
        }catch (LogisticsExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }

    }

    @GetMapping("/track-order/{orderId}")
    public ResponseEntity<?> trackOrder(@PathVariable("orderId") UUID orderId){
        try{
            return new ResponseEntity<>(userServices.trackOrder(orderId), FOUND);
        }catch (LogisticsExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }


    @PutMapping("/assign-order-to-agent{orderId}")
    public ResponseEntity<?> assignOrder(@PathVariable("orderId") UUID orderId){
        try{
            return new ResponseEntity<>(logisticAgent.assignOrder(orderId), OK);
        }catch (LogisticsExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }

    @GetMapping("/find-all-agents")
    public ResponseEntity<?> findAllAgents(){
     return new ResponseEntity<>(logisticAgent.findAllAgents(),FOUND);
    }
}
