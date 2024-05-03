package com.semicolon.africa.zoomlogistics.dto;

import lombok.Data;

@Data
public class AddressRequest {
    private Long id;
    private String cityName;
    private  String  countryName;
    private  String  state;
    private  String  houseNumber;
    private  String street;
}
