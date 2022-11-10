package com.example.newproject;

public class Comment {
    String body;
    Article owner;
    Comment parent;

    public Comment() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Article getOwner() {
        return owner;
    }

    public void setOwner(Article owner) {
        this.owner = owner;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }
}
