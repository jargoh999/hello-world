package com.semicolon.africa.zoomlogistics.attributeconverters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.africa.zoomlogistics.data.models.Order;
import jakarta.persistence.AttributeConverter;

public class OrderAttributeConverter implements AttributeConverter <Order,String> {

        private static final ObjectMapper objectMapper = new ObjectMapper();


        @Override
        public String convertToDatabaseColumn(Order order) {
            try {
                return objectMapper.writeValueAsString(order);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public Order convertToEntityAttribute(String value) {
            try {
                return objectMapper.readValue(value, Order.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }



