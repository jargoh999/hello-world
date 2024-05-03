package com.semicolon.africa.zoomlogistics.dto;

import com.semicolon.africa.zoomlogistics.data.models.Address;
import lombok.Data;

@Data
public class SignUpRequest{
    private String username;
    private String email;
    private String phoneNumber;
    private Address residentialAddress;
}
