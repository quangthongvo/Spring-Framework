package com.vti.blog_app.validation;

import com.vti.blog_app.repository.CommentRepository;
import com.vti.blog_app.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentIdExistsValidator
        implements ConstraintValidator<CommentIdExists, Long> {
    private CommentRepository commentRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return commentRepository.existsById(id);
    }
}
