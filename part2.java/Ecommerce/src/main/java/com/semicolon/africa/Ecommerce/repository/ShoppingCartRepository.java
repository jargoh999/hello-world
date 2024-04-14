package com.semicolon.africa.Ecommerce.repository;
import com.semicolon.africa.Ecommerce.data.models.Item;
import com.semicolon.africa.Ecommerce.data.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    ShoppingCart findShoppingCartByItems(List<Item> items);
    ShoppingCart findShoppingCartByNumberOfItems(int numberOfItems);
}
