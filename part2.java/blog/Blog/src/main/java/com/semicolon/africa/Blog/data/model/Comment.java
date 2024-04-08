package com.semicolon.africa.Blog.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Comments")
public class Comment {
    @DBRef
private User commenter;
@Id
private String id;
private String comment;
private String contentCommentedOn;
}
