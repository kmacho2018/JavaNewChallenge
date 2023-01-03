package com.example.javacodingchallenge.service;

import com.example.javacodingchallenge.controller.CategoryController;
import com.example.javacodingchallenge.dao.repository.CategoryRepository;
import com.example.javacodingchallenge.dao.repository.SubCategoryRepository;
import com.example.javacodingchallenge.model.Category;
import com.example.javacodingchallenge.model.KeyWord;
import com.example.javacodingchallenge.model.SubCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final static Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<KeyWord> getKeyWordsByCategory(String categoryName) {
        List<KeyWord> keyWords = categoryRepository.findByName(categoryName).getKeyWords();
        return keyWords;
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    public SubCategory getSubCategoryByName(String subCategoryName) {
        return subCategoryRepository.findByName(subCategoryName);
    }
}
