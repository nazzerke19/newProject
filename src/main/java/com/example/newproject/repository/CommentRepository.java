package com.example.newproject.repository;

import com.example.newproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> getCommentsByBodyContaining(@Param("word") String word);
    List<Comment> findAllByOrderByNumberOfLikes();
//    @Modifying
//    @Query(value = "update Comment set number_of_likes = number_of_likes + 1 where id = :id RETURNING *;", nativeQuery = true)
//    Integer addLikeToComment(@Param("id") Long id);

}
