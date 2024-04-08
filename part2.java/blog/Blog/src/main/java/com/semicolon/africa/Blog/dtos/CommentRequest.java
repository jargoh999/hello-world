package com.semicolon.africa.Blog.dtos;
import lombok.Data;
@Data
public class CommentRequest {
    private String commenterUserName;
    private String comment;
    private String postContent;
}
