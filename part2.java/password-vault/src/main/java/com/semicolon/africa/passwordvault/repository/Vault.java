package com.semicolon.africa.passwordvault.repository;
import com.semicolon.africa.passwordvault.models.ValuablesInVault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Vault extends JpaRepository<ValuablesInVault,Long> {
    ValuablesInVault findValuablesInVaultsById(Long id);
}


