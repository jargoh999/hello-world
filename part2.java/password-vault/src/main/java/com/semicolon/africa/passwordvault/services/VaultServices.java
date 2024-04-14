package com.semicolon.africa.passwordvault.services;
import com.semicolon.africa.passwordvault.models.BankVitalDocuments;
import com.semicolon.africa.passwordvault.models.ValuablesInVault;
import java.util.List;

public interface VaultServices {
    ValuablesInVault addValuablesToVault(ValuablesInVault valuablesInVault);
    ValuablesInVault removeValuablesFromVault(ValuablesInVault valuablesInVault);
    List<ValuablesInVault> findValuablesInVaultByValuableType(ValuablesInVault valuablesInVault);
    Long getNumberOfValuablesInVault();
    List<ValuablesInVault> findValuablesInVaultsByMasterUsername(String masterUsername);
    ValuablesInVault findValuablesInVaultById(Long id);

    List<ValuablesInVault> findAllValuablesInVault();
}