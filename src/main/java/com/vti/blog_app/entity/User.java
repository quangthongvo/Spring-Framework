package com.vti.blog_app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "`user`")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "username", length = 50,unique = true, nullable = false)
    private String username;

    @Column(name = "email", length = 50,unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;
    @Column(name = "role", length = 50, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public enum Role {
        ADMIN , MANAGER , EMPLOYEE
    }
}
