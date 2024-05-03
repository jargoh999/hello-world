package com.semicolon.africa.zoomlogistics.services;
import com.semicolon.africa.zoomlogistics.data.models.Order;
import com.semicolon.africa.zoomlogistics.data.models.OrderHistory;
import com.semicolon.africa.zoomlogistics.dto.OrderRequest;
import com.semicolon.africa.zoomlogistics.dto.OrderResponse;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;

import java.util.List;
import java.util.UUID;
public interface OrderServices {
     Order findOrderById(UUID id);
     Order findOrderByUserId(Long userId);
     Order createOrder(OrderRequest orderRequest);
     List<OrderHistory> trackOrder(UUID orderId);
     Order cancelOrder(UUID orderId);
}

