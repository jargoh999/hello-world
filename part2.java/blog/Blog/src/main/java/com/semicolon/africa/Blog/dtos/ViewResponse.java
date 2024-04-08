package com.semicolon.africa.Blog.dtos;
import lombok.Data;
import java.time.LocalDateTime;
@Data
public class ViewResponse {
    private String contentViewed;
    private String viewerUserName;
    private LocalDateTime timeOfView;
}
