package com.example.javacodingchallenge.model;

import jakarta.persistence.*;

@Entity
public class KeyWord {
    @Id
    @GeneratedValue
    private Long keyWordId;
    @Column(name="Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;
}
