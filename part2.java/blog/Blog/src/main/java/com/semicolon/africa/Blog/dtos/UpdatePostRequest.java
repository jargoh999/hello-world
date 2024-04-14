package com.semicolon.africa.Blog.dtos;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UpdatePostRequest {
    private LocalDateTime timeCreated;
    private String title;
    private String content;
    private String posterUserName;
    private String id;
}
