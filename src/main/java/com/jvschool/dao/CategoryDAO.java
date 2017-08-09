package com.jvschool.dao;

import com.jvschool.entities.CategoryEntity;

import java.util.List;


public interface CategoryDAO {

    List<CategoryEntity> getAllProductCategories();
    CategoryEntity getProductCategoryById(int id);
    CategoryEntity getProductCategoryByName(String name);
    void addProductCategory(String name);
    void editCategory(CategoryEntity category);

}
