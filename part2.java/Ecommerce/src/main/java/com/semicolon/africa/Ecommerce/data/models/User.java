package com.semicolon.africa.Ecommerce.data.models;
import com.semicolon.africa.Ecommerce.mappers.AddressAttributeConverter;
import com.semicolon.africa.Ecommerce.mappers.BillingInformationConverter;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Table(name = "E-store-users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int age;
    private String emailAddress;
    private String userName;
    private String passWord;
    private String phoneNumber;
    private boolean isLoggedIn;
    @Convert(converter = AddressAttributeConverter.class)
    private Address address;
    private Role userRole;
}
