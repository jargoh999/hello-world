package org.semicolon.africa.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Document
public class Post {
private String title;
private LocalDateTime createdTime;
@DBRef
private List<Comment> comments;
@Id
private String id;
@DBRef
private List<View> views;
private String content;
}
