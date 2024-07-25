package com.vti.blog_app.service;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.form.CommentCreateForm;
import com.vti.blog_app.form.CommentFilterForm;
import com.vti.blog_app.form.CommentUpdateForm;
import com.vti.blog_app.repository.CommentRepository;
import com.vti.blog_app.repository.PostRepository;
import com.vti.blog_app.specification.CommentSpecification;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private ModelMapper modelMapper;

    @Override
    public Page<CommentDto> findAll(CommentFilterForm form, Pageable pageable) {
        var spec = CommentSpecification.buildSpec(form);
        return commentRepository.findAll(spec, pageable)
                .map(comment -> modelMapper
                        .map(comment, CommentDto.class)
                        .withSelfRel());
    }

    @Override
    public Page<CommentDto> findByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable)
                .map(comment -> modelMapper
                        .map(comment, CommentDto.class)
                        .withSelfRel());
    }

    @Override
    public CommentDto findById(Long id) {
        return commentRepository.findById(id)
                .map(comment -> modelMapper
                        .map(comment, CommentDto.class)
                        .withSelfRel())
                .orElse(null);

    }

    @Override
    public CommentDto create(Long postId, CommentCreateForm form) {
        var optional = postRepository.findById(postId);
        if (optional.isEmpty()){
            return null;
        }
        var post = optional.get();
        var comment = modelMapper.map(form, CommentDto.class);
        comment.setPost(post);
        var savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public CommentDto update(Long id, CommentUpdateForm form) {
        var optional = commentRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        var comment = optional.get();
        modelMapper.map(form, comment);
        var savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByEmail(String email) {
        commentRepository.deleteByEmail(email);
    }
}
