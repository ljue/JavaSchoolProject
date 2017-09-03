package com.jvschool.dao.api;

import com.jvschool.model.CategoryEntity;

import java.util.List;


public interface CategoryDAO {

    List<CategoryEntity> getAllProductCategories();
    CategoryEntity getProductCategoryById(int id);
    CategoryEntity getProductCategoryByName(String name);
    void addProductCategory(String name);
    void editCategory(CategoryEntity category);
    void removeCategory(CategoryEntity category);
    List<CategoryEntity> getRemovedCategories();
    void returnCategory(CategoryEntity category);

}
