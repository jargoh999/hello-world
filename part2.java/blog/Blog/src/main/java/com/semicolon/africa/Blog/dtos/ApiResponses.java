package com.semicolon.africa.Blog.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ApiResponses {
    private  boolean isSuccessful;
   private  RegisterResponse registerResponse;
}
