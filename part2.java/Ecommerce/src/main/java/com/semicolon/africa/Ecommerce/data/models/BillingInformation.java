package com.semicolon.africa.Ecommerce.data.models;
import com.semicolon.africa.Ecommerce.mappers.AddressAttributeConverter;
import com.semicolon.africa.Ecommerce.mappers.CreditCardInfoAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

@Data
@Entity
public class BillingInformation {
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long Id;
  private String phoneNumber;
  @Convert(converter = AddressAttributeConverter.class)
  private Address deliveryAddress;
  @Convert(converter = CreditCardInfoAttributeConverter.class)
  private CreditCardInfo cardInfo;
}

