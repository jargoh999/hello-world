package com.semicolon.africa.zoomlogistics.data.models;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "logistic-address")
public class Address {
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Id
 private Long id;
 private String cityName;
 private  String  countryName;
 private  String  state;
 private  String  houseNumber;
 private  String street;
}
