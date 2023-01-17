package com.example.javacodingchallenge.service;

import com.example.javacodingchallenge.dao.repository.CategoryRepository;
import com.example.javacodingchallenge.models.Category;
import com.example.javacodingchallenge.models.KeyWord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Juan Camacho
 */
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
        try {
            if (category.isPresent()) {
                keyWords = category.get().getKeyWords();
            }
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return keyWords;
    }

    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    /**
     * Method for get Category by Category Id.
     *
     * @param categoryId
     * @return
     */
    public Category getCategoryByCategoryId(long categoryId) {
        Category category = null;
        category = categoryRepository.findById(categoryId).get();
        return category;
    }

    /**
     * Method for get List of Keywords by Category Name
     *
     * @param categoryName
     * @return
     */
    public Set<String> getKeyWordsByCategoryName(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        List<String> keyWordList = new ArrayList<>();
        try {
            if (category != null) {
                keyWordList = category.getKeyWords().stream().map(KeyWord::getName).collect(Collectors.toList());
                while (category.getParentCategoryId() != null) {
                    List<KeyWord> parentKeyWords = getKeyWordsByCategoryId(category.getParentCategoryId());
                    for (KeyWord keyword : parentKeyWords) {
                        keyWordList.add(keyword.getName());
                    }
                    category = getCategoryByCategoryId(category.getParentCategoryId());
                }
            }
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
        }
        return new LinkedHashSet<>(keyWordList);
    }
}
