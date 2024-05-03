package com.semicolon.africa.zoomlogistics.controllers;

import com.semicolon.africa.zoomlogistics.data.models.*;
import com.semicolon.africa.zoomlogistics.dto.AddressRequest;
import com.semicolon.africa.zoomlogistics.dto.UpdateAgentHistoryRequest;
import com.semicolon.africa.zoomlogistics.exceptions.LogisticsExceptions;
import com.semicolon.africa.zoomlogistics.services.LogisticAgentServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class LogisticServiceControllers {
    @Autowired
    private LogisticAgentServicesImpl logisticAgentServices;
    @GetMapping("/logistic/{id}")
    public LogisticAgent findLogisticAgentById(@PathVariable("id") UUID id){
        try {
            return logisticAgentServices.findLogisticAgentById(id);
        }catch (LogisticsExceptions exceptions){
            return null;
        }
    }


    public LogisticAgent findLogisticAgentByVehicleType(@RequestBody AgentVehicleType vehicleType){
        try {
            return logisticAgentServices.findLogisticAgentByVehicleType(vehicleType);
        }catch (LogisticsExceptions exceptions){
            return null;
        }

    }

    @PutMapping("/assign-order{orderId}")
    public OrderHistory assignOrder( @PathVariable("orderId") UUID orderId){
        try {
            return logisticAgentServices.assignOrder(orderId);
        }catch (LogisticsExceptions exceptions){
            return null;
        }
    }

    @PutMapping ("/update-agent-location{orderId}")
   public OrderHistory updateAgentHistory(@RequestBody AddressRequest location, @PathVariable("orderId")UUID orderId){

        try {
            return logisticAgentServices.updateAgentHistory(location,orderId);
        }catch (LogisticsExceptions exceptions){
            return null;
        }
    }


}
