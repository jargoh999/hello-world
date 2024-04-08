package com.semicolon.africa.Blog.data.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Document
public class Post {
private String posterUserName;
private String title;
private LocalDateTime createdTime;
@DBRef
private List<Comment> comments = new ArrayList<>();
@Id
private String id;
@DBRef
private List<View> views = new ArrayList<>();
private String content;
}


