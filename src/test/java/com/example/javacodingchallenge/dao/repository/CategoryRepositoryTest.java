package com.example.javacodingchallenge.dao.repository;

import com.example.javacodingchallenge.models.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * @author Juan Camacho
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Test for get all Categories.
     */
    @Test
    public void findAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        assertThat(categoryList.size()).isGreaterThanOrEqualTo(1);
        ;
    }

    /**
     * Test for load a Single Category
     */
    @Test
    public void findCategory() {
        Category category = categoryRepository.findByName("Lawn And Garden");
        Assert.assertNotNull(category);
    }

    /**
     * Test for get list of Keywords by Caytegory Name
     */
    @Test
    public void findKeyWordsByCategory() {
        Category category = categoryRepository.findByName("Lawn And Garden");
        Assert.assertTrue(category.getKeyWords().size() >= 1);
    }
}
