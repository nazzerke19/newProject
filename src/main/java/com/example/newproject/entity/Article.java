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
@MappedSuperclass
public abstract class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "image")
    private String image;
    @Column(name = "body")
    private String body;



}
