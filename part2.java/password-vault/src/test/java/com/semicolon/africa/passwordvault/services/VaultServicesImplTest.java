package com.semicolon.africa.passwordvault.services;

import com.semicolon.africa.passwordvault.models.*;
import com.semicolon.africa.passwordvault.repository.Vault;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class VaultServicesImplTest {

   @Autowired
    private Vault vault;

    @Autowired
    private VaultServicesImpl vaultServices;


    @Test
    void addValuablesToVault() {
        vault.deleteAll();
        BankVitalDocuments bankVitalDocuments = new BankVitalDocuments();
                bankVitalDocuments.setBvn("1234");
        vaultServices.addValuablesToVault(bankVitalDocuments);

        assertEquals(1L, vaultServices.getNumberOfValuablesInVault());

    }

    @Test
    void removeValuablesFromVault() {
        vault.deleteAll();
        BankVitalDocuments bankVitalDocuments = new BankVitalDocuments();
        bankVitalDocuments.setBvn("1234");
        vaultServices.addValuablesToVault(bankVitalDocuments);
        assertEquals(1L, vaultServices.getNumberOfValuablesInVault());
        vaultServices.removeValuablesFromVault(bankVitalDocuments);
        assertEquals(0L, vaultServices.getNumberOfValuablesInVault());

    }

    @Test
    void findValuablesByUserName() {
        vault.deleteAll();
        BankVitalDocuments bankVitalDocuments = new BankVitalDocuments();
        bankVitalDocuments.setBvn("1234");
        bankVitalDocuments.setMasterUsername("Master");
        vaultServices.addValuablesToVault(bankVitalDocuments);
        PrivateNotes notes = new PrivateNotes();
        notes.setPersonalNote("i am a boy");
        notes.setMasterUsername("Master");
        vaultServices.addValuablesToVault(notes);
        vaultServices.findValuablesInVaultsByMasterUsername("Master");
        assertEquals(2L, vaultServices.getNumberOfValuablesInVault());
    }

    @Test
    void findValuablesInVaultByValuableType() {
        vault.deleteAll();
        BankVitalDocuments bankVitalDocuments = new BankVitalDocuments();
        bankVitalDocuments.setBvn("1234");
        bankVitalDocuments.setMasterUsername("Master");
        vaultServices.addValuablesToVault(bankVitalDocuments);
        BankVitalDocuments bankVitalDocuments1 = new BankVitalDocuments();
        bankVitalDocuments1.setMasterUsername("Master");
        bankVitalDocuments1.setOtherDocuments("other");
        vaultServices.addValuablesToVault(bankVitalDocuments1);
        assertEquals(2, vaultServices.findValuablesInVaultByValuableType(bankVitalDocuments).size());
    }

    @Test
     void testToFindValuablesById(){
        vault.deleteAll();
        BankVitalDocuments bankVitalDocuments = new BankVitalDocuments();
        bankVitalDocuments.setBvn("1234");
        bankVitalDocuments.setMasterUsername("Master");
        vaultServices.addValuablesToVault(bankVitalDocuments);
        BankVitalDocuments bankVitalDocuments1 = new BankVitalDocuments();
        bankVitalDocuments1.setMasterUsername("Master");
        bankVitalDocuments1.setOtherDocuments("other");
        BankVitalDocuments bankVitalDocuments2 = new BankVitalDocuments();
        bankVitalDocuments2.setBvn("12345");
        bankVitalDocuments2.setMasterUsername("Master");
        vaultServices.addValuablesToVault(bankVitalDocuments2);
        vaultServices.addValuablesToVault(bankVitalDocuments1);
        PrivateNotes notes = new PrivateNotes();
        notes.setPersonalNote("i am a boy");
        notes.setMasterUsername("Master");
        vaultServices.addValuablesToVault(notes);
       assertTrue(vaultServices.findValuablesInVaultById(2L) instanceof BankVitalDocuments);
       assertEquals(bankVitalDocuments2.getCardCvv(), ((BankVitalDocuments) vaultServices.findValuablesInVaultById(2L)).getCardCvv()
       );
       assertTrue(vaultServices.findValuablesInVaultById(4L) instanceof PrivateNotes);
    }

}
