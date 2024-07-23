package com.vti.blog_app.dto;

import com.vti.blog_app.controller.PostController;
import com.vti.blog_app.entity.Post;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class PostDto extends RepresentationModel<PostDto> {
    private Long id;
    private String title;
    private String content;
    private String description;
    private Post.Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostDto withSelfRel(){
        var controller = methodOn(PostController.class);
        var dto = controller.findById(id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}
