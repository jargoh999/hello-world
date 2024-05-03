package com.semicolon.africa.zoomlogistics.services;
import com.semicolon.africa.zoomlogistics.data.models.OrderHistory;

import java.util.List;
import java.util.UUID;
public interface OrderHistoryServices {
    OrderHistory findOrderHistoryById(Long id);
    OrderHistory findOrderHistoryByAgentId(Long id);
    List<OrderHistory> findOrderHistoriesByOrderId(UUID orderId);
}
