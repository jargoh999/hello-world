package com.semicolon.africa.zoomlogistics.services;

import com.semicolon.africa.zoomlogistics.data.models.*;
import com.semicolon.africa.zoomlogistics.dto.AddressRequest;
import com.semicolon.africa.zoomlogistics.repository.Addresses;
import com.semicolon.africa.zoomlogistics.repository.LogisticAgents;
import com.semicolon.africa.zoomlogistics.repository.OrderHistoryRepository;
import com.semicolon.africa.zoomlogistics.repository.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.semicolon.africa.zoomlogistics.utils.Mappers.mapAddressRequestToAddress;
import static com.semicolon.africa.zoomlogistics.utils.Mappers.mapAddressRequestToResponse;

@Service
public class LogisticAgentServicesImpl implements LogisticAgentServices{
    @Autowired
    private LogisticAgents logisticAgents;
    @Autowired
    private Orders orders;
    @Autowired
    private OrderHistoryRepository orderHistoryRepository;
    @Autowired
    private Addresses addresses;





    @Override
    public LogisticAgent findLogisticAgentById(UUID id) {
        return logisticAgents.findLogisticAgentById(id);
    }

    @Override
    public LogisticAgent findLogisticAgentByVehicleType(AgentVehicleType vehicleType) {
        return logisticAgents.findLogisticAgentByVehicleType(vehicleType);
    }

    @Override
    public LogisticAgent findLogisticAgentByAvailability(AvailabilityState availabilityState) {
        return logisticAgents.findLogisticAgentByAvailability(availabilityState);
    }

    @Override
    public LogisticAgent findLogisticAgentByAgentName(String agentName) {
        return logisticAgents.findLogisticAgentByAgentName(agentName);
    }

    @Override
    public LogisticAgent findLogisticAgentByOrders(List<Order> orders) {
        return null;
    }

    @Override
    public OrderHistory assignOrder(UUID orderId) {
             String[] NamesOfRider = {"tunji","beejay","dayo","marvellous","soft-life"};
             var types = new ArrayList<>();
             Collections.addAll(types,AgentVehicleType.values());
             int detailSelector = new SecureRandom().nextInt(0,4);
             var order=orders.findOrderById(orderId);
             order.setOrderStatus(OrderStatus.PICKED_UP);
             order.setTimeAssigned(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
             LogisticAgent logisticAgent = new LogisticAgent();
             logisticAgent.setAgentName(NamesOfRider[detailSelector]);
             logisticAgent.setVehicleType((AgentVehicleType) types.toArray()[detailSelector]);
             logisticAgent.setAvailability(AvailabilityState.IN_TRANSIT);
             logisticAgent.getOrders().add(order);
             orders.save(order);
             logisticAgents.save(logisticAgent);
             OrderHistory orderHistory = getAgentHistory(order, logisticAgent);
             orderHistoryRepository.save(orderHistory);
             return orderHistory;
    }

    @Override
    public List<LogisticAgent> findAllAgents() {
        return logisticAgents.findAll();
    }

    private OrderHistory getAgentHistory(Order order, LogisticAgent logisticAgent) {
        OrderHistory orderHistory = new OrderHistory();
        orderHistory.setOrderId(order.getId());
        orderHistory.setCurrentOrderStatus(OrderStatus.PICKED_UP);
        orderHistory.setCurrentLocation(order.getPickUpLocation());
        orderHistory.setTimeUpdated(order.getTimeAssigned());
        orderHistory.setRemarks(String.format("%s%s%s","your rider name is  ",
        logisticAgent.getAgentName()+" "+"his id is ->", logisticAgent.getId()));
        logisticAgent.setAvailability(AvailabilityState.IN_TRANSIT);
        return orderHistory;
    }


    @Override
    public OrderHistory updateAgentHistory(AddressRequest addressRequest, UUID orderId) {
               Address address = new Address();
               mapAddressRequestToAddress(addressRequest,address);
               addresses.save(address);
               OrderHistory orderHistory = new OrderHistory();
               addressRequest.setId(address.getId());
               orderHistory.setCurrentLocation(address);
               orderHistory.setOrderId(orderId);
               orderHistory.setTimeUpdated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
               orderHistory.setCurrentOrderStatus(OrderStatus.ON_ITS_WAY);
               orderHistory.setRemarks("your order is on it way its current location is ->  "+ mapAddressRequestToResponse(addressRequest));
               return orderHistoryRepository.save(orderHistory);
    }

    @Override
    public OrderHistory completeDelivery(UUID orderId) {
        return null;
    }
}
