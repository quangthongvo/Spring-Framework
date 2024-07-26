package com.vti.blog_app.dto;

import com.vti.blog_app.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private User.Role role;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
