package com.semicolon.africa.Blog.services;

import com.semicolon.africa.Blog.dtos.ViewRequest;
import com.semicolon.africa.Blog.dtos.ViewResponse;

public interface ViewServices {
    ViewResponse viewPosts(ViewRequest viewRequest);
}
