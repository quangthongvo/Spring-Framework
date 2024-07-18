package com.vti.blog_app.repository;

import com.vti.blog_app.dto.CommentDto;
import com.vti.blog_app.entity.Comment;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    // cach 1: method name
    // tien to: findBy, existBy, countBy, deleteBy
    // lay ra tat ca cac comment theo name

    List<Comment> findByName(String name);
    // lay ra tat ca cac comment co body chua "search"

    List<Comment> findByBodyContaining(String search);

    // lay ra tat ca cac comment theo name hoac email
    List<Comment> findByNameOrEmail(String name, String email);

    // lay ra tat ca cac comment theo post id
    Page<Comment> findByPostId(Long postId, Pageable pageable);

    // cach 2. @Query
    //
    @Modifying
    @Query("DELETE FROM Comment WHERE email = :email")
    void deleteByEmail(@Param("email") String email);

    @Modifying
    @Query("DELETE FROM Comment WHERE name = ?1 AND email = ?2")
    void deleteByNameAndEmail(String name, String email);

}
