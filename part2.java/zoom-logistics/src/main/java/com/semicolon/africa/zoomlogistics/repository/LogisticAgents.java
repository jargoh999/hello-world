package com.semicolon.africa.zoomlogistics.repository;

import com.semicolon.africa.zoomlogistics.data.models.AgentVehicleType;
import com.semicolon.africa.zoomlogistics.data.models.AvailabilityState;
import com.semicolon.africa.zoomlogistics.data.models.LogisticAgent;
import com.semicolon.africa.zoomlogistics.data.models.Order;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LogisticAgents extends JpaRepository<LogisticAgent,Long> {
    LogisticAgent findLogisticAgentById(UUID id);
    LogisticAgent findLogisticAgentByVehicleType(AgentVehicleType vehicleType);
    LogisticAgent findLogisticAgentByAvailability(AvailabilityState availabilityState);
    LogisticAgent findLogisticAgentByAgentName(String agentName);
    LogisticAgent findLogisticAgentByOrders(List<Order> orders);

}
