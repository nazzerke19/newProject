package com.example.newproject.service;

import com.example.newproject.entity.Blog;
import com.example.newproject.model.BlogModel;
import com.example.newproject.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;

    public BlogModel addBlog(Blog blog){
        return BlogModel.toModel(blogRepository.save(blog));
    }

    public List<BlogModel> getAllBlogs() {
        Iterable<Blog> blogList = blogRepository.findAll();
        List<BlogModel> blogModelList = new ArrayList<>();
        for (Blog blog:blogList) {
            BlogModel blogModel = BlogModel.toModel(blog);
            blogModelList.add(blogModel);
        }
        return blogModelList;
    }

    public BlogModel getBlogById(Long id) {
        return BlogModel.toModel(blogRepository.findById(id).get());
    }

    public BlogModel updateBlog(Long id, BlogModel blog) {
        Blog blog1 = blogRepository.findById(id).get();
        blog1.setTitle(blog.getTitle());
        blog1.setBody(blog.getBody());
        blog1.setAuthor(blog.getAuthor());
        return BlogModel.toModel(blogRepository.save(blog1));
    }

    public BlogModel updatePartiallyBlog(Long id, BlogModel blogModel) {
        Blog blogModel1 = blogRepository.findById(id).get();
        if (blogModel.getTitle() != null) blogModel1.setTitle(blogModel.getTitle());
        if (blogModel.getBody() != null) blogModel1.setBody(blogModel.getBody());
        if (blogModel.getAuthor() != null) blogModel1.setAuthor(blogModel.getAuthor());
        return BlogModel.toModel(blogModel1);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
