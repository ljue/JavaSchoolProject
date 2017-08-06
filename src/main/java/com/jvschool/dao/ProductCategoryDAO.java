package com.jvschool.dao;

import com.jvschool.entities.ProductCategoryEntity;

import java.util.List;


public interface ProductCategoryDAO {

    List<ProductCategoryEntity> getAllProductCategories();
    ProductCategoryEntity getProductCategoryById(int id);
    ProductCategoryEntity getProductCategoryByName(String name);
    void addProductCategory(String name);
    void editCategory(ProductCategoryEntity category);

}
