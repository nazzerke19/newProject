package com.example.newproject.repository;

import com.example.newproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> getCommentsByBodyContaining(@Param("word") String word);
}
