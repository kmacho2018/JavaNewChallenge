package com.example.javacodingchallenge.dao.repository;

import com.example.javacodingchallenge.model.Category;
import com.example.javacodingchallenge.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    SubCategory findByName(String subCategoryName);
}
