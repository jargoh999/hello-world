package com.semicolon.africa.zoomlogistics.repository;

import com.semicolon.africa.zoomlogistics.data.models.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.rmi.server.UID;
import java.util.List;
import java.util.UUID;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory , Long> {
    OrderHistory findOrderHistoryById(Long id);
    OrderHistory findOrderHistoryByRemarks(String remarks);
    List<OrderHistory> findOrderHistoriesByOrderId(UUID orderId);
}
