package com.vti.blog_app.service;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.entity.Comment;
import com.vti.blog_app.form.CommentCreateForm;
import com.vti.blog_app.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    Page<CommentDto> findAll(Pageable pageable);

    Page<CommentDto> findByPostId(Long postId, Pageable pageable);

    CommentDto findById(Comment.primaryKey id);

    CommentDto create(Long postId, CommentCreateForm form);

    CommentDto update(Comment.primaryKey id, CommentUpdateForm form);

    void deleteById(Comment.primaryKey id);
    void deleteByEmail(String email);
}
