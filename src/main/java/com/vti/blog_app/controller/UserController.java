package com.vti.blog_app.controller;

import com.vti.blog_app.dto.PostDto;
import com.vti.blog_app.dto.UserDto;
import com.vti.blog_app.form.PostCreateForm;
import com.vti.blog_app.form.UserCreateForm;
import com.vti.blog_app.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/api/v1/users")
    public UserDto create(@Valid @RequestBody UserCreateForm form){
        return userService.create(form);
    }
}
