package com.semicolon.africa.Blog.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private PostResponse postResponse;
}
