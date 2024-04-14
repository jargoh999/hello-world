package com.semicolon.africa.passwordvault.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BankVitalDocuments extends ValuablesInVault {
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Id
    private Long id;
    private String cardCvv;
    private String atmPassword;
    private String certificates;
    private String otherDocuments;
    private String bvn;
    private String will;
    private String contract;
}
