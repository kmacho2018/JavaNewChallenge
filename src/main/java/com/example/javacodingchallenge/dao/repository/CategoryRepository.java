package com.example.javacodingchallenge.dao.repository;

import com.example.javacodingchallenge.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String categoryName);
}
