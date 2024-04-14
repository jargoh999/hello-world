package com.semicolon.africa.passwordvault.controllers;

import com.semicolon.africa.passwordvault.dto.*;
import com.semicolon.africa.passwordvault.exception.VaultExceptions;
import com.semicolon.africa.passwordvault.models.PrivateNotes;
import com.semicolon.africa.passwordvault.models.ValuablesInVault;
import com.semicolon.africa.passwordvault.models.WebsiteUserNameAndPassword;
import com.semicolon.africa.passwordvault.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/vault")
public class UserServicesController {

     @Autowired
     private UserServicesImpl userServices;

     @PostMapping("/sign-up")
     public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest){
         try {
             return new ResponseEntity<>(userServices.signUp(signUpRequest),CREATED);
         }catch (VaultExceptions exceptions){
              return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
         }
     }

    @PostMapping("/log-in")
    public ResponseEntity<?> logIn(@RequestBody LogInRequest logInRequest){
        try {
            return new ResponseEntity<>(userServices.logIn(logInRequest),CREATED);
        }catch (VaultExceptions exceptions){
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/log-out")
    public ResponseEntity<?> logOut(@RequestBody LogInRequest logInRequest){
        try {
            return new ResponseEntity<>(userServices.logOut(logInRequest),CREATED);
        }catch (VaultExceptions exceptions){
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/delete-a-valuable-in-vault")
    public ResponseEntity<?> deleteAValuable(@RequestBody ValuablesInVault valuablesInVault){
        try {
            return new ResponseEntity<>(userServices.removeValuablesFromVault(valuablesInVault),CREATED);
        }catch (VaultExceptions exceptions){
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/add-web-information-to-vault")
    public ResponseEntity<?> addWebInfo(@RequestBody WebInfoRequest valuablesInVault) {
        try {
            return new ResponseEntity<>(userServices.addValuablesToVault(valuablesInVault), CREATED);
        } catch (VaultExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }


    @PostMapping("/add-notes-to-vault")
    public ResponseEntity<?> addNotesToVault(@RequestBody PrivateNotesRequest valuablesInVault) {
        try {
            return new ResponseEntity<>(userServices.addValuablesToVault(valuablesInVault), CREATED);
        } catch (VaultExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }


    @PostMapping("/add-bank-info-to-vault")
    public ResponseEntity<?> addBankInfo(@RequestBody BankVitalDocumentsRequest valuablesInVault) {
        try {
            return new ResponseEntity<>(userServices.addValuablesToVault(valuablesInVault), CREATED);
        } catch (VaultExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }



    @PostMapping("/find-valuables-in-vault-by-type")
    public ResponseEntity<?> findValuableByType(@RequestBody ValuablesInVault valuablesInVault) {
        try {
            return new ResponseEntity<>(userServices.findValuablesInVaultByValuableType(valuablesInVault), CREATED);
        } catch (VaultExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }



    @GetMapping("/find-all-valuables-that-belong-to/{master}")
    public ResponseEntity<?> getAllValuableThatBelongTo(@PathVariable("master") String master){
        try {
            return new ResponseEntity<>(userServices.findValuablesInVaultsByMasterUsername(master), CREATED);
        } catch (VaultExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }


    @GetMapping("/find-valuables-in-vault-by-id/{id}")
    public ResponseEntity<?> findValuablesById(@PathVariable("id") Long id){
        try {
            return new ResponseEntity<>(userServices.findValuablesInVaultById(id), CREATED);
        } catch (VaultExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }

    @GetMapping("/find-all-valuables-in-vault")
    public ResponseEntity<?> findValuablesInVault(){
        try {
            return new ResponseEntity<>(userServices.findAllValuablesInVault(), CREATED);
        } catch (VaultExceptions exceptions) {
            return new ResponseEntity<>(exceptions.getMessage(), BAD_REQUEST);
        }
    }





}
