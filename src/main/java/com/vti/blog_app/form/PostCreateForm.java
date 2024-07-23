package com.vti.blog_app.form;

import com.vti.blog_app.entity.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class PostCreateForm {
    @NotBlank(message = "Post title must not be blank")
    @Length(max = 50, message = "Post title has max 50 characters")
    private String title;

    @NotBlank
    @Length(max = 150)
    private String content;

    @NotBlank
    @Length(max = 100)
    private String description;

    @NotNull
    @Pattern(regexp = "OPENING|CLOSED",
            message = "Post status must be OPENING or CLOSED")
    private String status;
}
