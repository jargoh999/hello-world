package com.semicolon.africa.passwordvault.services;


import com.semicolon.africa.passwordvault.dto.*;
import com.semicolon.africa.passwordvault.models.*;

import java.util.List;

public interface UserServices {

    LogInResponse logIn(LogInRequest logInRequest);
    LogInResponse logOut(LogInRequest logInRequest);

    SignUpResponse signUp(SignUpRequest signUpRequest);

    ValuablesInVault addValuablesToVault(WebInfoRequest webInfoRequest);

    ValuablesInVault addValuablesToVault(PrivateNotesRequest privateNotes);


    ValuablesInVault addValuablesToVault(BankVitalDocumentsRequest bankVitalDocuments);
    ValuablesInVault removeValuablesFromVault(ValuablesInVault valuablesInVault);
    List<ValuablesInVault> findValuablesInVaultByValuableType(ValuablesInVault valuablesInVault);
    Long getNumberOfValuablesInVault();
    List<ValuablesInVault> findValuablesInVaultsByMasterUsername(String masterUsername);
    ValuablesInVault findValuablesInVaultById(Long id);

    List<ValuablesInVault> findAllValuablesInVault();

}
