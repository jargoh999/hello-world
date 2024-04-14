package com.semicolon.africa.passwordvault.dto;

import lombok.Data;

@Data
public class BankVitalDocumentsRequest {
    private String cardCvv;
    private String atmPassword;
    private String certificates;
    private String otherDocuments;
    private String bvn;
    private String will;
    private String contract;
    private String masterUserName;

}
