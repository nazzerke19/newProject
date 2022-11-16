package com.example.newproject.entity;

import com.example.newproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "newstable")
@DiscriminatorValue("newstype")
public class News extends Article {


}
