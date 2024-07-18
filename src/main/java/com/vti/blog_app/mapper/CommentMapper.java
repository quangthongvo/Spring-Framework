package com.vti.blog_app.mapper;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.entity.Comment;
import com.vti.blog_app.form.CommentCreateForm;
import com.vti.blog_app.form.CommentUpdateForm;

public class CommentMapper {
    public static Comment map(CommentCreateForm form){
        var comment = new Comment();
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(form.getBody());
        return comment;
    }
    public static CommentDto map(Comment comment){
        var dto = new CommentDto();
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        dto.setCreatedAt(comment.getCreateAt());
        dto.setUpdatedAt(comment.getUpdateAt());
        return dto;
    }
    public static void map(CommentUpdateForm form, Comment comment){
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setBody(comment.getBody());
    }
}
