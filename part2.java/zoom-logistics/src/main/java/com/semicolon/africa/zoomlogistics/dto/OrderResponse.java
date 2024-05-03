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
public class OrderResponse {
    private UUID id;
    private List<Item> items = new ArrayList<>();
    private OrderStatus orderStatus;
    private Address pickUpLocation;
    private Address deliveryAddress;
    private Long userId;
    private LocalDateTime timePlaced;
}
