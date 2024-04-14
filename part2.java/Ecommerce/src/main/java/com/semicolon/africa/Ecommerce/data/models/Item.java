package com.semicolon.africa.Ecommerce.data.models;
import com.semicolon.africa.Ecommerce.mappers.ProductAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class Item {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    @Convert(converter = ProductAttributeConverter.class)
    private Product product;
    private int numberOfProduct;
 }



