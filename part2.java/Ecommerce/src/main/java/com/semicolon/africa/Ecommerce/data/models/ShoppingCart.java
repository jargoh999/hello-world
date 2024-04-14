package com.semicolon.africa.Ecommerce.data.models;
import com.semicolon.africa.Ecommerce.mappers.ItemAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import java.util.List;
@Data
@Entity
public class ShoppingCart {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    @Convert(converter = ItemAttributeConverter.class)
    @OneToMany(fetch = FetchType.EAGER)
    private List<Item> items;
    private int numberOfItems;
}

