package com.example.newproject.service;

import com.example.newproject.entity.Article;
import com.example.newproject.entity.Blog;
import com.example.newproject.entity.Comment;
import com.example.newproject.entity.News;
import com.example.newproject.model.CommentModel;
import com.example.newproject.model.NewsModel;
import com.example.newproject.repository.BlogRepository;
import com.example.newproject.repository.CommentRepository;
import com.example.newproject.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    NewsRepository newsRepository;

    public CommentModel addComment(Comment comment) {
        return CommentModel.toModel(commentRepository.save(comment));
    }
    public List<CommentModel> getAllComments() {
        Iterable<Comment> comments = commentRepository.findAll();
        List<CommentModel> commentModel = new ArrayList<>();
        for (Comment comment:comments){
            CommentModel commentModel1 = CommentModel.toModel(comment);
            commentModel.add(commentModel1);
        }
        return commentModel;
    }

    public CommentModel getById(Long id){
        return CommentModel.toModel(commentRepository.findById(id).get());
    }

    public CommentModel addCommentToComment(Long id,Comment comment) {
        Comment comment1 = commentRepository.findById(id).get();
        comment.setParent(comment1);
        comment.setOwner(comment1.getOwner());
        return  CommentModel.toModel(commentRepository.save(comment));
    }

    public CommentModel updateComment(Long id, CommentModel commentModel){
        Comment comment = commentRepository.findById(id).get();
        Optional<News> news = newsRepository.findById(commentModel.getOwnerId());
        Optional<Blog> blog = blogRepository.findById(commentModel.getOwnerId());
        if (news.isPresent()) comment.setOwner(news.get());
        if (blog.isPresent()) comment.setOwner(blog.get());
        Optional<Comment> comment1 = commentRepository.findById(commentModel.getParentId());
        if (comment1.isPresent()) comment.setParent(comment1.get());
        comment.setBody(commentModel.getBody());
        return  CommentModel.toModel(commentRepository.save(comment));
    }

    public CommentModel updatePartiallyComment(Long id, CommentModel commentModel) {
        Comment comment = commentRepository.findById(id).get();
        comment.setParent(commentModel.getParent());
        comment.setBody(commentModel.getBody());
        comment.setOwner(commentModel.getOwner());
        return CommentModel.toModel(commentRepository.save(comment));
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
