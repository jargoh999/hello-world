package com.semicolon.africa.zoomlogistics.data.models;

import com.semicolon.africa.zoomlogistics.attributeconverters.OrderAttributeConverter;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class LogisticAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String agentName;
    private AgentVehicleType vehicleType;
    private AvailabilityState availability;
    @JoinColumn(name = "agent_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Convert(converter = OrderAttributeConverter.class)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
