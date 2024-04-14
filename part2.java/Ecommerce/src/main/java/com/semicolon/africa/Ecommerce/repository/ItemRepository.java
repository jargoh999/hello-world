package com.semicolon.africa.Ecommerce.repository;
import com.semicolon.africa.Ecommerce.data.models.Item;
import com.semicolon.africa.Ecommerce.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
    Item findItemByProduct(Product product);
    Item findItemByNumberOfProduct(int numberOfProduct);

}
