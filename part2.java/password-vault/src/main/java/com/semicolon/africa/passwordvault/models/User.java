package com.semicolon.africa.passwordvault.models;

import com.semicolon.africa.passwordvault.attributeConverters.ValuablesInVaultAttributeConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String masterPassword;
    private String masterUserName;
    private boolean isActive;
    @OneToMany(fetch = FetchType.EAGER)
    @Convert(converter = ValuablesInVaultAttributeConverter.class)
    private List<ValuablesInVault> valuablesInVaults = new ArrayList<>();
}



