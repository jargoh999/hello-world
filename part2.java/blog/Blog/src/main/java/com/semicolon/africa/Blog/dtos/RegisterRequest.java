package com.semicolon.africa.Blog.dtos;
import lombok.Data;
@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
}
