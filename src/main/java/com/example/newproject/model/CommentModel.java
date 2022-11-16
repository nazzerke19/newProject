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
    private Long ownerId;
    private Long parentId;
    private String ownerTitle;


    public static CommentModel toModel(Comment comment){
        CommentModel commentModel = new CommentModel();
        commentModel.setParentId(comment.getParent().getId());
        commentModel.setBody(comment.getBody());
        if (comment.getId()!=null) commentModel.setOwnerId(comment.getOwner().getId());
        commentModel.setOwnerTitle(comment.getOwner().getTitle());
        return commentModel;
    }
}
