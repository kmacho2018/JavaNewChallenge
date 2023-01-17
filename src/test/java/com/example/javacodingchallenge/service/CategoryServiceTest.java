package com.example.javacodingchallenge.service;

import com.example.javacodingchallenge.dao.repository.CategoryRepository;
import com.example.javacodingchallenge.models.Category;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

/**
 * @author Juan Camacho
 */
@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepositoryMock;

    @InjectMocks
    private CategoryService categoryService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    void initUseCase() {
        categoryService = new CategoryService(categoryRepositoryMock);
    }

    @Test
    public void testGetCategoryByName() {
        Category category = new Category();
        when(categoryRepositoryMock.findByName("Lawn And Garden")).thenReturn(category);
        Category fetchedCategory = categoryService.getCategoryByName("Lawn And Garden");
        Assert.assertEquals(category, fetchedCategory);
    }
}
