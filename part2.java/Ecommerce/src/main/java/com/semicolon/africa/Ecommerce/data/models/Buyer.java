package com.semicolon.africa.Ecommerce.data.models;
import com.semicolon.africa.Ecommerce.mappers.BillingInformationConverter;

import com.semicolon.africa.Ecommerce.mappers.ShoppingCartConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Buyer extends User {
    @Convert(converter = BillingInformationConverter.class)
    @Column(length =388)
    private  BillingInformation billingInformation;
    @Convert(converter = ShoppingCartConverter.class)
    private ShoppingCart shoppingCart;
}
