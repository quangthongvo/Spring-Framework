package com.vti.blog_app.dto;

import com.vti.blog_app.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String description;
    private Post.Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
