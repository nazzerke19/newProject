package com.example.newproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.*;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="discriminator",
        discriminatorType = DiscriminatorType.STRING)
@Entity(name = "article")
public  class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "body")
    private String body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
