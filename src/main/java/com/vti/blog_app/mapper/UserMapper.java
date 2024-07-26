package com.vti.blog_app.mapper;

import com.vti.blog_app.dto.UserDto;
import com.vti.blog_app.entity.User;
import com.vti.blog_app.form.UserCreateForm;

public class UserMapper {
    public static User map(UserCreateForm form){
        var user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        return user;
    }
    public static UserDto map(User user){
        var dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        dto.setCreateAt(user.getCreatedAt());
        dto.setUpdateAt(user.getUpdatedAt());
        return dto;
    }
}
