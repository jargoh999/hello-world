package com.semicolon.africa.zoomlogistics.repository;
import com.semicolon.africa.zoomlogistics.data.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface Orders extends JpaRepository<Order,Long> {
    Order findOrderById(UUID id);
    Order findOrderByUserId(Long userId);
}
