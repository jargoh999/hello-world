package com.semicolon.africa.passwordvault.dto;

import lombok.Data;

@Data
public class PrivateNotesRequest {
    private String secretStickyNote;
    private String giftDeedNote;
    private String personalNote;
    private String businessDocument;
    private String masterUserName;
}
