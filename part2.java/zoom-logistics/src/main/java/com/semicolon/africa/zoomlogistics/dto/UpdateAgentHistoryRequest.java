package com.semicolon.africa.zoomlogistics.dto;

import com.semicolon.africa.zoomlogistics.data.models.Address;
import lombok.Data;

import java.util.UUID;

@Data
public class UpdateAgentHistoryRequest {
    private Address CurrentLocation;
    private UUID orderToBeUpdatedId;
}
