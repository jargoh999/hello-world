package com.semicolon.africa.zoomlogistics.dto;
import com.semicolon.africa.zoomlogistics.data.models.Address;
import com.semicolon.africa.zoomlogistics.data.models.Item;
import com.semicolon.africa.zoomlogistics.data.models.OrderStatus;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
public class OrderRequest {
    private UUID id;
    private List<Item> items = new ArrayList<>();
    private OrderStatus orderStatus;
    private Address deliveryAddress;
    private LocalDateTime timeAccepted;
    private LocalDateTime timePlaced;
    private LocalDateTime timeDelivered;
    private LocalDateTime timeCancelled;
    private Long userId;
}
