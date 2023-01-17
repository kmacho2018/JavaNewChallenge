package com.example.javacodingchallenge.controller;

import com.example.javacodingchallenge.service.CategoryService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author Juan Camacho
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private CategoryController categoryController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {

        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
    }

    /**
     * Test for consume GetKeyWord by Category Name
     *
     * @throws Exception
     */
    @Test
    public void testGetKeyWordsByCategoryName()
            throws Exception {
        mockMvc.perform(get("/category/getKeyWords?CategoryName=Lawn%20And%20Garden")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    /**
     * Test for get Level of Category
     *
     * @throws Exception
     */
    @Test
    public void testLevelCategoryOperation()
            throws Exception {
        mockMvc.perform(get("/category/getLevelCategory?CategoryName=Lawn%20And%20Garden")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
