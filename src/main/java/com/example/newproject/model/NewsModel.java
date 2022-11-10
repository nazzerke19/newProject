package com.example.newproject.model;

import com.example.newproject.entity.News;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewsModel {
    private Long id;
    private String title;
    private String body;

    public static NewsModel toModel(News entity){
        NewsModel model = new NewsModel();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setBody(entity.getBody());
        return model;
    }
}
