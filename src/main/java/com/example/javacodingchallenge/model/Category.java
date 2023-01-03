package com.example.javacodingchallenge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Category implements Serializable {
    @Id
    @GeneratedValue
    private Long categoryId;
    @Column(name="Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private List<SubCategory> subCategories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private List<KeyWord> keyWords;
}
