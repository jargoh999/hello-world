package com.semicolon.africa.zoomlogistics.data.models;
import com.semicolon.africa.zoomlogistics.attributeconverters.AddressAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID orderId;
    private OrderStatus currentOrderStatus;
    private LocalDateTime timeUpdated;
    @JoinColumn(name = "current_location")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Convert(converter = AddressAttributeConverter.class)
    private Address currentLocation;
    private String remarks;
}
