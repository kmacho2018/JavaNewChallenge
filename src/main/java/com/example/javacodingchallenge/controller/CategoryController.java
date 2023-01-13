package com.example.javacodingchallenge.controller;

import com.example.javacodingchallenge.models.Category;
import com.example.javacodingchallenge.models.KeyWord;
import com.example.javacodingchallenge.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CategoryController {

    private final static Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/getKeyWords")
    public Set<String> getKeyWordsByCategoryName(@RequestParam(name = "CategoryName") String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        List<String> keyWordList = new ArrayList<>();
        if (category != null) {
            keyWordList = category.getKeyWords().stream().map(KeyWord::getName).collect(Collectors.toList());
            if (category.getParentCategoryId() != null) {
                List<KeyWord> parentKeyWords = categoryService.getKeyWordsByCategoryId(category.getParentCategoryId());
                for (KeyWord keyword : parentKeyWords) {
                    keyWordList.add(keyword.getName());
                }
            }
        }
        return new LinkedHashSet<>(keyWordList);
    }

    @GetMapping("/category/getLevelCategory")
    public String getCategoryLevel(@RequestParam(name = "CategoryName") String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        if (category.getParentCategoryId() != null) {
            Category parentCategory = categoryService.getCategoryByCategoryId(category.getParentCategoryId());
            return "The Category " + category.getName() + " Is Subcategory of " + parentCategory.getName();
        } else {
            return "The Category " + category.getName() + " Is the part of Main Categories.";
        }
    }
}
