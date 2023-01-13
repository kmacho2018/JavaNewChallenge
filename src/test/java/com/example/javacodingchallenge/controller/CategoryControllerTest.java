package com.example.javacodingchallenge.controller;

import com.example.javacodingchallenge.service.CategoryService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryControllerTest {
    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetKeyWordByCategory() {
        Set<String> result=new HashSet<>();
        result.add("Lawn");
        result.add("Garden");
        result.add("GardeningTools");
        Set<String> result2=new HashSet<>();

        Mockito.when(categoryController.getKeyWordsByCategoryName("Lawn And Garden")).thenReturn(result);
        Assert.assertEquals(result,result2);
    }


}
