package com.example.newproject;

import java.awt.*;

public class Article {
    String title;
    Image image;
    String body;

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public Image getImage() {
        return image;
    }


}
