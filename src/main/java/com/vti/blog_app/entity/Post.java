package com.vti.blog_app.entity;

import com.vti.blog_app.converter.PostStatusConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "content", length = 150, nullable = false)
    private String content;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //@OneToMany(mappedBy = "post")
   // private List<Comment> comments;

    @Column(name = "status" , nullable = false)
    //@Enumerated(EnumType.STRING)
    @Convert(converter = PostStatusConverter.class)
    private Status status;
    public enum Status{
        OPENING , CLOSED
    }
}
