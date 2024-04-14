package com.semicolon.africa.Ecommerce.data.models;

import com.semicolon.africa.Ecommerce.mappers.ProductAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Seller extends User{
     @Convert(converter = ProductAttributeConverter.class)
     @OneToMany(fetch=FetchType.EAGER)
     private List<Product> products;
}
