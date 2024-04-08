package com.semicolon.africa.Blog.dtos;
import com.semicolon.africa.Blog.data.model.User;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class PostResponse {
    private LocalDateTime timeCreated;
    private String title;
    private String content;
    private String posterUserName;
}
