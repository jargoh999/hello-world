package com.semicolon.africa.passwordvault.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class ValuablesInVault {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String MasterUsername;
}
