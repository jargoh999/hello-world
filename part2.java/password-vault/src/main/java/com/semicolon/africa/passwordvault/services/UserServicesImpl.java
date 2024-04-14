package com.semicolon.africa.passwordvault.services;
import com.semicolon.africa.passwordvault.dto.*;
import com.semicolon.africa.passwordvault.dto.LogInResponse;
import com.semicolon.africa.passwordvault.dto.SignUpRequest;
import com.semicolon.africa.passwordvault.dto.SignUpResponse;
import com.semicolon.africa.passwordvault.exception.AlreadyInActiveException;
import com.semicolon.africa.passwordvault.exception.InactiveStateException;
import com.semicolon.africa.passwordvault.exception.UserAlreadyExistException;
import com.semicolon.africa.passwordvault.exception.UserNotFoundException;
import com.semicolon.africa.passwordvault.models.*;
import com.semicolon.africa.passwordvault.repository.Users;
import com.semicolon.africa.passwordvault.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
   private Users users;
    @Autowired
    private VaultServicesImpl vaultServices;
    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest){
        User user = new User();
        Mappers.mapRequestToUser(signUpRequest,user);
        if(findUserByUsername(user.getMasterUserName())==null)users.save(user);
        else throw new UserAlreadyExistException("user already exist");
        return Mappers.mapSignUpRequestToResponse(signUpRequest);
    }


    @Override
    public ValuablesInVault addValuablesToVault(WebInfoRequest request) {
                     var user = findUserByUsername(request.getMasterUsername());
                     if(user == null)throw new UserNotFoundException("user not found");
                     if(!user.isActive())throw new InactiveStateException("you are inactive");
                     WebsiteUserNameAndPassword websiteUserNameAndPassword = new WebsiteUserNameAndPassword(null,request.getPassword(), request.getWebsiteInformation());
                     websiteUserNameAndPassword.setMasterUsername(request.getMasterUsername());
                     return vaultServices.addValuablesToVault(websiteUserNameAndPassword);
    }

    @Override
    public ValuablesInVault addValuablesToVault(PrivateNotesRequest privateNotes) {
        var user = findUserByUsername(privateNotes.getMasterUserName());
        if(user == null)throw new UserNotFoundException("user not found");
        if(!user.isActive())throw new InactiveStateException("you are inactive");
        PrivateNotes notes = new PrivateNotes(null
        ,privateNotes.getSecretStickyNote(),
        privateNotes.getGiftDeedNote(), privateNotes.getPersonalNote(), privateNotes.getBusinessDocument());
        notes.setMasterUsername(privateNotes.getMasterUserName());
        return vaultServices.addValuablesToVault(notes);
    }

    @Override
    public ValuablesInVault addValuablesToVault(BankVitalDocumentsRequest bankVitalDocuments) {
        var user = findUserByUsername(bankVitalDocuments.getMasterUserName());
        if(user == null)throw new UserNotFoundException("user not found");
        if(!user.isActive())throw new InactiveStateException("you are inactive");
        BankVitalDocuments bankVitals = new BankVitalDocuments(null, bankVitalDocuments.getCardCvv(), bankVitalDocuments.getAtmPassword(), bankVitalDocuments.getCertificates(), bankVitalDocuments.getOtherDocuments(), bankVitalDocuments.getBvn(), bankVitalDocuments.getWill(), bankVitalDocuments.getContract());  //
        bankVitals.setMasterUsername(bankVitalDocuments.getMasterUserName());
        return vaultServices.addValuablesToVault(bankVitals);
    }


    @Override
    public ValuablesInVault removeValuablesFromVault(ValuablesInVault valuablesInVault) {
        var user =findUserByUsername(valuablesInVault.getMasterUsername());
        if(user == null)throw new UserNotFoundException("user not found");
        if(!user.isActive())throw new InactiveStateException("you are inactive");
        return vaultServices.removeValuablesFromVault(valuablesInVault);
    }

    @Override
    public List<ValuablesInVault> findValuablesInVaultByValuableType(ValuablesInVault valuablesInVault) {
        var user =findUserByUsername(valuablesInVault.getMasterUsername());
        if(user == null)throw new UserNotFoundException("user not found");
        if(!user.isActive())throw new InactiveStateException("you are inactive");
        return vaultServices.findValuablesInVaultByValuableType(valuablesInVault);
    }

    @Override
    public Long getNumberOfValuablesInVault() {
        return vaultServices.getNumberOfValuablesInVault();
    }

    @Override
    public List<ValuablesInVault> findValuablesInVaultsByMasterUsername(String masterUsername) {
        var user = findUserByUsername(masterUsername);
        if(user == null)throw new UserNotFoundException("user not found");
        if(!user.isActive())throw new InactiveStateException("you are inactive");
        return vaultServices.findValuablesInVaultsByMasterUsername(masterUsername);
    }

    @Override
    public ValuablesInVault findValuablesInVaultById(Long id) {
        return vaultServices.findValuablesInVaultById(id);
    }

    @Override
    public List<ValuablesInVault> findAllValuablesInVault() {
        return vaultServices.findAllValuablesInVault();
    }

    @Override
    public LogInResponse logIn(LogInRequest logInRequest) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = users.findUsersByMasterUserName(logInRequest.getUsername());
        if(user == null) throw new UserNotFoundException("User not found");
        if(!passwordEncoder.
        matches(logInRequest.getPassword(), user.getMasterPassword())) throw new UserNotFoundException("incorrect password");
        user.setActive(true);
        user.setValuablesInVaults(vaultServices.findValuablesInVaultsByMasterUsername(user.getMasterUserName()));
        users.save(user);
        return Mappers.mapUserToResponse(user);
    }

    @Override
    public LogInResponse logOut(LogInRequest logInRequest) {
        User user = users.findUsersByMasterUserName(logInRequest.getUsername());
        if (user.isActive()) user.setActive(false);
        else throw new AlreadyInActiveException("you are already logged out");
        user.setValuablesInVaults(vaultServices.findValuablesInVaultsByMasterUsername(user.getMasterUserName()));
        users.save(user);
        return Mappers.mapUserToResponse(user);
    }

    private User findUserByUsername(String  username) {

        for (var user:users.findAll()) {
               if(user.getMasterUserName().equals(username))return user;
        }
        return null;
    }


}