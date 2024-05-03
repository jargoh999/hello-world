package com.semicolon.africa.zoomlogistics.services;

import com.semicolon.africa.zoomlogistics.data.models.*;
import com.semicolon.africa.zoomlogistics.dto.OrderRequest;
import com.semicolon.africa.zoomlogistics.exceptions.OrderNotFoundExp;
import com.semicolon.africa.zoomlogistics.repository.Addresses;
import com.semicolon.africa.zoomlogistics.repository.Items;
import com.semicolon.africa.zoomlogistics.repository.OrderHistoryRepository;
import com.semicolon.africa.zoomlogistics.repository.Orders;
import com.semicolon.africa.zoomlogistics.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServicesImpl implements OrderServices {
    @Autowired
    private Orders orders;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Autowired
    private Addresses addresses;
    @Autowired
    private Items items;
    @Override
    public Order findOrderById(UUID id) {
        return orders.findOrderById(id);
    }

    @Override
    public Order findOrderByUserId(Long userId) {
        return orders.findOrderByUserId(userId);
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        orderRequest.setOrderStatus(OrderStatus.PLACED);
        order.setOrderStatus(orderRequest.getOrderStatus());
        order.setItems(orderRequest.getItems());
        items.saveAll(orderRequest.getItems());
        order.setTimePlaced(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        return orders.save(order);
    }

    public void updateOrder(UUID orderId,OrderRequest orderRequest){
            var order =orders.findOrderById(orderId);
            if(order==null) throw new OrderNotFoundExp("Order not found");
            Mappers.mapOrderRequestToOrder(orderRequest, order);
            orders.save(order);
    }

    @Override
    public List<OrderHistory> trackOrder(UUID orderId) {
        var theOrder =orders.findOrderById(orderId);
         if(theOrder==null) throw new OrderNotFoundExp("not another mistake :(");
        return orderHistoryRepository.findOrderHistoriesByOrderId(orderId);
    }

    @Override
    public Order cancelOrder(UUID orderId) {
        if(findOrderById(orderId) == null) throw new OrderNotFoundExp
        ("Order Was never placed in the first place or may have been canceled");
        var order = orders.findOrderById(orderId);
         if(order.getOrderStatus() == OrderStatus.DECLINED)
          throw new OrderNotFoundExp(String.format( "%s%s","order was already canceled at", order.getTimeRejected()));
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderId(order.getId());
        orderHistory.setTimeUpdated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        orderHistory.setCurrentOrderStatus(OrderStatus.DECLINED);
        orderHistory.setCurrentLocation(order.getPickUpLocation());
        orderHistory.setRemarks("order was cancelled");
        orderHistoryRepository.save(orderHistory);
        orders.save(order);
        order.setTimeRejected(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        orders.save(order);
        return order;
    }
}
