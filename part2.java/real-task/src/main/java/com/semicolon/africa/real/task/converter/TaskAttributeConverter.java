package com.semicolon.africa.real.task.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.africa.real.task.data.models.TodoTask;
import jakarta.persistence.AttributeConverter;


public class TaskAttributeConverter implements AttributeConverter<TodoTask,String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(TodoTask todoTask) {
        try {
            return objectMapper.writeValueAsString(todoTask);
        }catch (JsonProcessingException jsonProcessingException){
                return jsonProcessingException.getMessage();
        }
    }

    @Override
    public TodoTask convertToEntityAttribute(String value) {
        try{
              return objectMapper.readValue(value, TodoTask.class);
        }catch (JsonProcessingException jsonProcessingException){
                 throw new RuntimeException();
        }
    }
}
