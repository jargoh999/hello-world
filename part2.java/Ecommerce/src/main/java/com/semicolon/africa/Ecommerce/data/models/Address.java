package com.semicolon.africa.Ecommerce.data.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
public class Address {
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Id
 private long id;
 private String cityName;
 private  String  countryName;
 private  String  state;
 private  String  houseNumber;
 private  String street;
}
