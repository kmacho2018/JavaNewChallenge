package com.example.javacodingchallenge.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Juan Camacho
 */
@Entity
@Getter
@Setter
public class Category implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "Category_Id")
    private Long categoryId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "Parent_Category_Id")
    private Long parentCategoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId", fetch = FetchType.LAZY)
    private List<KeyWord> keyWords;
}
