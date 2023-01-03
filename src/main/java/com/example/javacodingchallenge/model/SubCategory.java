package com.example.javacodingchallenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue
    private Long subCategoryId;
    @Column(name="Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;
}
