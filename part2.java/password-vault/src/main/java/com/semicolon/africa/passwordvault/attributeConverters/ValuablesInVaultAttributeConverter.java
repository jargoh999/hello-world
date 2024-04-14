package com.semicolon.africa.passwordvault.attributeConverters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.africa.passwordvault.models.ValuablesInVault;
import jakarta.persistence.AttributeConverter;

import java.nio.charset.CoderMalfunctionError;

public class ValuablesInVaultAttributeConverter implements AttributeConverter<ValuablesInVault,String> {

   private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ValuablesInVault valuablesInVault) {
        try{
                 return mapper.writeValueAsString(valuablesInVault);
        }catch (JsonProcessingException jsonProcessingException){
                   return jsonProcessingException.getMessage();

        }
    }

    @Override
    public ValuablesInVault convertToEntityAttribute(String value) {
        try{
            return mapper.readValue(value,ValuablesInVault.class);
        }catch (JsonProcessingException jsonProcessingException){
            throw new RuntimeException("Error processing value ");
        }
    }

}
