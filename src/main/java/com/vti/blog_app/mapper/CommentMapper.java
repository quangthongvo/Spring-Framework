package com.vti.blog_app.mapper;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.entity.Comment;
import com.vti.blog_app.form.CommentCreateForm;
import com.vti.blog_app.form.CommentUpdateForm;

public class CommentMapper {
    public static Comment map(CommentCreateForm form){
        var comment = new Comment();
        var pk = new Comment.primaryKey();
        pk.setName(form.getName());
        pk.setEmail(form.getEmail());
        comment.setPk(comment.getPk());
        comment.setBody(comment.getBody());
        return comment;
    }
    public static CommentDto map(Comment comment){
        var dto = new CommentDto();
        dto.setPk(comment.getPk());
        dto.setBody(comment.getBody());
        dto.setCreatedAt(comment.getCreateAt());
        dto.setUpdatedAt(comment.getUpdateAt());
        return dto;
    }
    public static void map(CommentUpdateForm form, Comment comment){
        var pk = new Comment.primaryKey();
        pk.setName(form.getName());
        pk.setEmail(form.getEmail());
        comment.setPk(comment.getPk());
        comment.setBody(form.getBody());
    }
}
