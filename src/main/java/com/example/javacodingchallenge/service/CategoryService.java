package com.example.javacodingchallenge.service;

import com.example.javacodingchallenge.dao.repository.CategoryRepository;
import com.example.javacodingchallenge.models.Category;
import com.example.javacodingchallenge.models.KeyWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final static Logger LOG = LoggerFactory.getLogger(CategoryService.class);

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<KeyWord> getKeyWordsByCategoryId(long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        List<KeyWord> keyWords = new ArrayList<>();
        if (category.isPresent()) {
            keyWords = category.get().getKeyWords();
        }
        return keyWords;
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    public Category getCategoryByCategoryId(long categoryId) {
        Category category= null;
        category = categoryRepository.findById(categoryId).get();
        return  category;
    }
}
