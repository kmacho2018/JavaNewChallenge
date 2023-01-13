package com.example.javacodingchallenge.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Key_Word")
public class KeyWord {
    @Id
    @GeneratedValue
    @Column(name="Key_Word_Id")
    private Long keyWordId;
    @Column(name="Name")
    private String name;

    @Column(name = "category_Id")
    private long categoryId;

  /*  @ManyToOne
    @JoinColumn(name = "category_Id",nullable = false,insertable=false, updatable=false)
    private Category category;*/
}
