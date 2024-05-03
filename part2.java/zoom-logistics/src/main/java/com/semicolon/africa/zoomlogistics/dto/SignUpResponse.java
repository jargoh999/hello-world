package com.semicolon.africa.zoomlogistics.dto;

import com.semicolon.africa.zoomlogistics.data.models.Address;
import lombok.Data;

@Data
public class SignUpResponse {
    private String username;
    private String email;
    private Address residentialAddress;
    private Long id;
}
