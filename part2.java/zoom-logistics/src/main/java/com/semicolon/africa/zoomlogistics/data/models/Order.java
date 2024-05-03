package com.semicolon.africa.zoomlogistics.data.models;

import com.semicolon.africa.zoomlogistics.attributeconverters.AddressAttributeConverter;
import com.semicolon.africa.zoomlogistics.attributeconverters.ItemAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "logistic-order")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    @JoinColumn(name = "items_in_order")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Convert(converter = ItemAttributeConverter.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();
    private OrderStatus orderStatus;
    @JoinColumn(name = "pick_up_location")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Convert(converter = AddressAttributeConverter.class)
    private Address pickUpLocation;
    @JoinColumn(name = "delivery_address")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Convert(converter = AddressAttributeConverter.class)
    private Address deliveryAddress;
    private LocalDateTime timeAssigned;
    private LocalDateTime timePlaced;
    private LocalDateTime timeRejected;
    private LocalDateTime timeDelivered;
    private Long userId;
}

