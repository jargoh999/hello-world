package com.semicolon.africa.Ecommerce.repository;
import com.semicolon.africa.Ecommerce.data.models.Product;
import com.semicolon.africa.Ecommerce.data.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findProductByProductCategory(ProductCategory productCategory);
    Product findProductByProductPrice(BigDecimal price);
    Product findProductByProductName(String name);
    Product findProductByProductDescription(String Description);
}
