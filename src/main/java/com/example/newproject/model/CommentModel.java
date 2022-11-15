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
    private Article owner;
    private Comment parent;
    public static CommentModel toModel(Comment comment){
        CommentModel commentModel = new CommentModel();
        commentModel.setParentId(comment.getParent().getId());
        //commentModel.setParent(comment.getParent());
        commentModel.setBody(comment.getBody());
        commentModel.setOwnerId(comment.getOwner().getId());
        commentModel.setOwnerTitle(comment.getOwner().getTitle());
        return commentModel;
    }
}
