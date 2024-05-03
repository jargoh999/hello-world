package com.semicolon.africa.zoomlogistics.services;

import com.semicolon.africa.zoomlogistics.data.models.*;
import com.semicolon.africa.zoomlogistics.dto.AddressRequest;
import com.semicolon.africa.zoomlogistics.dto.UpdateAgentHistoryRequest;

import java.util.List;
import java.util.UUID;

public interface LogisticAgentServices {
    LogisticAgent findLogisticAgentById(UUID id);
    LogisticAgent findLogisticAgentByVehicleType(AgentVehicleType vehicleType);
    LogisticAgent findLogisticAgentByAvailability(AvailabilityState availabilityState);
    LogisticAgent findLogisticAgentByAgentName(String agentName);
    LogisticAgent findLogisticAgentByOrders(List<Order> orders);
    OrderHistory assignOrder(UUID orderId);
    List<LogisticAgent> findAllAgents();
    OrderHistory updateAgentHistory(AddressRequest addressRequest, UUID orderId);

    OrderHistory completeDelivery(UUID orderId);


}
