package com.example.javacodingchallenge.service;

import com.example.javacodingchallenge.dao.repository.CategoryRepository;
import com.example.javacodingchallenge.models.Category;
import com.example.javacodingchallenge.models.KeyWord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepositoryMock;

    @InjectMocks
    private CategoryService categoryService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getCategoryByName(){
        Category category = new Category();
        Mockito.when(categoryRepositoryMock.findByName("Lawn And Garden")).thenReturn(category);
        Assert.assertNotNull(category);
    }

    @Test
    public void getKeyWordByCategory(){
        List<KeyWord> keyWordList = new ArrayList<>();
        Mockito.when(categoryService.getKeyWordsByCategoryId(3)).thenReturn(keyWordList);
        Assert.assertNotNull(keyWordList);
    }
}
