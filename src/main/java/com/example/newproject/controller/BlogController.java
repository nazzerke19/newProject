package com.example.newproject.controller;

import com.example.newproject.entity.Blog;
import com.example.newproject.model.BlogModel;
import com.example.newproject.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @PostMapping
    public BlogModel addBlog(@RequestBody Blog blog) {
        return blogService.addBlog(blog);
    }

    @GetMapping
    public ResponseEntity getAllBlogs() {
        return ResponseEntity.ok(blogService.getAllBlogs());
    }

    @GetMapping("{id}")
    public  ResponseEntity getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<BlogModel> updateBlog(@PathVariable Long id, @RequestBody BlogModel blog) {
        return ResponseEntity.ok(blogService.updateBlog(id, blog));
    }

    @PatchMapping("{id}")
    public ResponseEntity<BlogModel> updatePartiallyBlog(@PathVariable Long id, @RequestBody BlogModel blogModel) {
        return ResponseEntity.ok(blogService.updatePartiallyBlog(id,blogModel));
    }

    @DeleteMapping("{id}")
    public void deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
    }
}
