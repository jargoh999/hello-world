package com.semicolon.africa.Ecommerce.data.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    private long productId;
    private String productName;
    private BigDecimal productPrice;
    private String productDescription;
    private ProductCategory productCategory;
}
