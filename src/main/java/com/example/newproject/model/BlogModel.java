package com.example.newproject.model;

import com.example.newproject.entity.Blog;
import com.example.newproject.entity.News;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BlogModel {
    private String title;
    private String body;
    private String author;

    public static BlogModel toModel(Blog entity){
        BlogModel model = new BlogModel();
        // model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setBody(entity.getBody());
        model.setAuthor(entity.getAuthor());
        return model;
    }
}
