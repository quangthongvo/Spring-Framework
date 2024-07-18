package com.vti.blog_app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class CommentDto {
    private String id;
    private String name;
    private String email;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
