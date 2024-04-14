package com.semicolon.africa.passwordvault.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PrivateNotes extends ValuablesInVault {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String secretStickyNote;
    private String giftDeedNote;
    private String personalNote;
    private String businessDocument;
}
