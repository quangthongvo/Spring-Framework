package com.vti.blog_app.controller;

import com.vti.blog_app.dto.PostDto;
import com.vti.blog_app.form.PostCreateForm;
import com.vti.blog_app.form.PostFilterForm;
import com.vti.blog_app.form.PostUpdateForm;
import com.vti.blog_app.service.PostService;
import com.vti.blog_app.validation.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class PostController {
    private PostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable){
        return postService.findAll(form, pageable);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id") @PostIdExists Long id){
        return postService.findById(id);
    }
    @PostMapping("/api/v1/posts")
    public PostDto create(@Valid @RequestBody PostCreateForm form){
        return postService.create(form);
    }
    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(
            @PathVariable("id") @PostIdExists Long id,
            @Valid @RequestBody PostUpdateForm form){
        return postService.update(id, form);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") @PostIdExists Long id){
        postService.deleteById(id);
    }
}
