package com.example.newproject.service;

import com.example.newproject.entity.Comment;
import com.example.newproject.model.CommentModel;
import com.example.newproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

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


}
