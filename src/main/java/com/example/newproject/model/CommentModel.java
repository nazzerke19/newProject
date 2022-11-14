package com.example.newproject.model;

import com.example.newproject.entity.Article;
import com.example.newproject.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
public class CommentModel {
    private String body;
    private Article owner;
    private Comment parent;

    public static CommentModel toModel(Comment comment){
        CommentModel commentModel = new CommentModel();
        commentModel.setBody(comment.getBody());
        commentModel.setParent(comment.getParent());
        commentModel.setOwner(comment.getOwner());
        return commentModel;
    }
}
