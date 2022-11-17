package com.example.newproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "body")
    private String body;

    @JoinColumn(name = "owner")
    @ManyToOne(cascade = CascadeType.MERGE)
    private Article owner;

    @JoinColumn(name = "parent")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Comment parent;

    @Column(name = "numberOfLikes")
    private Integer numberOfLikes=0;

}
