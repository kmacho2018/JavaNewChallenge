package com.example.javacodingchallenge.controller;

import com.example.javacodingchallenge.model.Category;
import com.example.javacodingchallenge.model.KeyWord;
import com.example.javacodingchallenge.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final static Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/getKeyWords")
    public List<KeyWord> getKeyWordsByCategoryName(@RequestParam(name = "CategoryName") String categoryName) {
        return categoryService.getKeyWordsByCategory(categoryName);
    }


    @GetMapping("/category/getLevelCategory")
    public String getCategoryLevel(@RequestParam(name = "CategoryName") String categoryName) {
        if (categoryService.getCategoryByName(categoryName) == null) {
            if (categoryService.getSubCategoryByName(categoryName) == null) {
                return "Category doesn't exists.";
            } else {
                return "Is a SubCategory Level";
            }
        } else return "Is a Category";
    }
}
