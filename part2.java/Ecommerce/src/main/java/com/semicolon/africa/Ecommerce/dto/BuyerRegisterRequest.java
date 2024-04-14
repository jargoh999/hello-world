package com.semicolon.africa.Ecommerce.dto;
import com.semicolon.africa.Ecommerce.data.models.Address;
import com.semicolon.africa.Ecommerce.data.models.BillingInformation;
import com.semicolon.africa.Ecommerce.data.models.CreditCardInfo;
import lombok.Data;

@Data
public class BuyerRegisterRequest {
    private int age;
    private String emailAddress;
    private String userName;
    private String passWord;
    private  String phoneNumber;
    private boolean isLoggedIn;
    private String DOB;
    private String role;
    private Address address;
    private BillingInformation billingInformation;
}
