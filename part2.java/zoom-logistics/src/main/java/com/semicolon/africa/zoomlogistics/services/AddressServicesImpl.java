package com.semicolon.africa.zoomlogistics.services;

import com.semicolon.africa.zoomlogistics.data.models.Address;
import com.semicolon.africa.zoomlogistics.dto.AddressRequest;
import com.semicolon.africa.zoomlogistics.dto.AddressResponse;
import com.semicolon.africa.zoomlogistics.exceptions.AddressNotFoundExp;
import com.semicolon.africa.zoomlogistics.repository.Addresses;
import com.semicolon.africa.zoomlogistics.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Keymap;

import java.util.List;

import static com.semicolon.africa.zoomlogistics.utils.Mappers.mapAddressRequestToAddress;
import static com.semicolon.africa.zoomlogistics.utils.Mappers.mapAddressRequestToResponse;

@Service
public class AddressServicesImpl implements AddressServices{

    @Autowired
    private Addresses addresses;
    @Override
    public Address findAddressById(Long id) {
        return addresses.findAddressById(id);
    }

    @Override
    public AddressResponse addAddress(AddressRequest addressRequest) {
        Address address = new Address();
        mapAddressRequestToAddress(addressRequest,address);
        var newAddress =addresses.save(address);
        addressRequest.setId(newAddress.getId());
       return mapAddressRequestToResponse(addressRequest);
    }

    @Override
    public AddressResponse updateAddress(Long id,AddressRequest addressRequest) {
        var address = addresses.findAddressById(id);
        if(findAddressById(address.getId())==null)throw new AddressNotFoundExp("address not found");
        mapAddressRequestToAddress(addressRequest,address);
        var newAddress= addresses.save(address);
        addressRequest.setId(newAddress.getId());
        return mapAddressRequestToResponse(addressRequest);
    }

    @Override
    public void addAllAddress(List<Address> newAddresses) {
              addresses.saveAll(newAddresses);
    }
}
