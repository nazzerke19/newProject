package com.example.newproject.controller;

import com.example.newproject.entity.Comment;
import com.example.newproject.model.CommentModel;
import com.example.newproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public CommentModel addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @GetMapping
    public ResponseEntity getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @GetMapping("/{id}")
    public ResponseEntity getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getById(id));
    }
}
