package com.vti.blog_app.form;

import com.vti.blog_app.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateForm {
    private String name;
    private String email;
    private String body;

}
