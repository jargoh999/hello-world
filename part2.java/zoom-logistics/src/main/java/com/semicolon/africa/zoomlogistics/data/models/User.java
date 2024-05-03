package com.semicolon.africa.zoomlogistics.data.models;

import com.semicolon.africa.zoomlogistics.attributeconverters.AddressAttributeConverter;
import com.semicolon.africa.zoomlogistics.attributeconverters.OrderAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.util.List;

@Data
@Entity
@Table(name = "logistics-user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    @JoinColumn(name = "orders")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Convert(converter = OrderAttributeConverter.class)
    private List<Order> orders;
    @JoinColumn(name = "residential_address")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Convert(converter = AddressAttributeConverter.class)
    private Address residentialAddress;
    private boolean  isActive;
}
