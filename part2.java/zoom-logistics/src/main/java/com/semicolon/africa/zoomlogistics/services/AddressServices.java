package com.semicolon.africa.zoomlogistics.services;

import com.semicolon.africa.zoomlogistics.data.models.Address;
import com.semicolon.africa.zoomlogistics.dto.AddressRequest;
import com.semicolon.africa.zoomlogistics.dto.AddressResponse;

import java.util.List;

public interface AddressServices {
    Address findAddressById(Long id);
    AddressResponse addAddress(AddressRequest addressRequest);
    AddressResponse updateAddress(Long id ,AddressRequest addressRequest);
    void addAllAddress(List<Address> addresses);
}
