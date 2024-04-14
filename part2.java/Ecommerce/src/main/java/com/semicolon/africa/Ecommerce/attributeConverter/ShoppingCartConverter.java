package com.semicolon.africa.Ecommerce.mappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.africa.Ecommerce.data.models.ShoppingCart;
import jakarta.persistence.AttributeConverter;

public class ShoppingCartConverter implements AttributeConverter<ShoppingCart,String> {
     private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ShoppingCart shoppingCart) {
        try {
            return mapper.writeValueAsString(shoppingCart);
        }catch (JsonProcessingException jsonProcessingException){
                   return jsonProcessingException.getMessage();
        }

    }

    @Override
    public ShoppingCart convertToEntityAttribute(String value) {
          try {
              return mapper.readValue(value, ShoppingCart.class);
          }catch (JsonProcessingException jsonProcessingException){
                  throw new RuntimeException();
          }
    }
}
