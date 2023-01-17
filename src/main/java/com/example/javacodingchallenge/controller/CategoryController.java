package com.example.javacodingchallenge.controller;

import com.example.javacodingchallenge.models.Category;
import com.example.javacodingchallenge.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author Juan Camacho
 */
@RestController
public class CategoryController {

    private final static Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Operation to get List of Keywords by Category Name
     * @param categoryName
     * @return
     */
    @GetMapping("/category/getKeyWords")
    public Set<String> getKeyWordsByCategoryName(@RequestParam(name = "CategoryName") String categoryName) {
        Set<String> keyWordList = null;
        try {
             keyWordList = categoryService.getKeyWordsByCategoryName(categoryName);
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return keyWordList;
    }

    /**
     * Operation to get of level by Category Name
     * @param categoryName
     * @return
     */
    @GetMapping("/category/getLevelCategory")
    public String getCategoryLevel(@RequestParam(name = "CategoryName") String categoryName) {
        Category category = categoryService.getCategoryByName(categoryName);
        try {
            if (category.getParentCategoryId() != null) {
                Category parentCategory = categoryService.getCategoryByCategoryId(category.getParentCategoryId());
                return "The Category " + category.getName() + " Is Subcategory of " + parentCategory.getName();
            } else {
                return "The Category " + category.getName() + " Is the part of Main Categories.";
            }
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return ex.getMessage();
        }
    }
}
