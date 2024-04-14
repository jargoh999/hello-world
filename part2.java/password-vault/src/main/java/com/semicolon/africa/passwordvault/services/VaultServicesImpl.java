package com.semicolon.africa.passwordvault.services;

import com.semicolon.africa.passwordvault.models.ValuablesInVault;
import com.semicolon.africa.passwordvault.repository.Vault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VaultServicesImpl implements VaultServices{
    @Autowired
    private Vault vault;
    @Override
    public ValuablesInVault addValuablesToVault(ValuablesInVault valuablesInVault) {
           return vault.save(valuablesInVault);
    }

    @Override
    public ValuablesInVault removeValuablesFromVault(ValuablesInVault valuablesInVault) {
         vault.delete(valuablesInVault);
         return valuablesInVault;
    }



    @Override
    public List<ValuablesInVault> findValuablesInVaultByValuableType(ValuablesInVault valuablesInVault) {

            return vault.findAll().stream().
            filter(valuables -> valuables.getClass()==valuablesInVault.getClass()).
            collect(Collectors.toList());
    }

    @Override
    public Long getNumberOfValuablesInVault() {
        return vault.count();
    }

    @Override
    public List<ValuablesInVault> findValuablesInVaultsByMasterUsername(String masterUsername) {
        return vault.findAll().stream().
                filter(valuables -> valuables.getMasterUsername().equalsIgnoreCase(masterUsername)).
                collect(Collectors.toList());
    }

    @Override
    public ValuablesInVault findValuablesInVaultById(Long id) {
        return vault.findValuablesInVaultsById(id);

    }

    @Override
    public List<ValuablesInVault> findAllValuablesInVault() {
        return vault.findAll();
    }


}
