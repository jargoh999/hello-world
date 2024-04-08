package com.semicolon.africa.Blog.dtos;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class PostRequest {
    private LocalDateTime timeCreated;
    private String title;
    private String content;
    private String posterUserName;
}

