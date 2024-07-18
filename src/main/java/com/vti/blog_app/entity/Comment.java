package com.vti.blog_app.entity;

import com.vti.blog_app.generator.CommentIdGenerator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
  @Id
  @EmbeddedId
  private primaryKey pk;

    @Column(name = "body", length = 100, nullable = false)
    private String body;

    @Column(name = "create_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createAt;

    @Column(name = "update_at", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;
    @Getter
    @Setter
    @Embeddable
    public static class primaryKey implements Serializable {
        @Column(name = "name", length = 50, nullable = false)
        private String name;

        @Column(name = "email", length = 75, nullable = false)
        private String email;
    }
}
