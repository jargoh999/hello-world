package com.semicolon.africa.passwordvault.dto;

import lombok.Data;

@Data
public class WebInfoRequest {
    private String password;
    private String websiteInformation;
    private String masterUsername;
}
