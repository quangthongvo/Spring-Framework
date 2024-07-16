package com.vti.blog_app.controller;

import com.vti.blog_app.dto.PostDto;
import com.vti.blog_app.form.PostCreateForm;
import com.vti.blog_app.form.PostUpdateForm;
import com.vti.blog_app.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAll(Pageable pageable){
        return postService.findAll(pageable);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id") Long id){
        return postService.findById(id);
    }
    @PostMapping("/api/v1/posts")
    public PostDto create(@RequestBody PostCreateForm form){
        return postService.create(form);
    }
    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(
            @PathVariable("id") Long id,
            @RequestBody PostUpdateForm form){
        return postService.update(id, form);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") Long id){
        postService.deleteById(id);
    }
}
