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

    @GetMapping("/orderbylike")
    public ResponseEntity getAllCommentsOrderedByLikes() {
        return ResponseEntity.ok(commentService.getOrderedCommentsByLikes());
    }

    @PatchMapping("/addlike/{id}")
    public ResponseEntity<CommentModel> addLike(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.addLikeToComment(id));
    }

    @GetMapping("/search")
    public ResponseEntity getCommentsContainsWord(@RequestParam(value = "word") String word) {
        return ResponseEntity.ok(commentService.getCommentThatContainsWord(word));
    }

    @PostMapping
    public CommentModel addComment(@RequestBody CommentModel comment) {
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

    @PostMapping("/{id}")
    public CommentModel addCommentToComment(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.addCommentToComment(id,comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentModel> updateComment(@PathVariable Long id, @RequestBody CommentModel comment) {
        CommentModel commentModel = commentService.updateComment(id, comment);
        return ResponseEntity.ok(commentModel);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentModel> updatePartiallyComment(@PathVariable Long id, @RequestBody CommentModel comment) {
        CommentModel commentModel = commentService.updatePartiallyComment(id, comment);
        return ResponseEntity.ok(commentModel);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        commentService.deleteById(id);
    }
}
