package com.jvschool.svc;

import com.jvschool.entities.ProductCategoryEntity;

import java.util.List;


public interface ProductCategoryService {
    List<ProductCategoryEntity> getAllProductCategories();
    List<String> getAllProductCategoryNames();
    ProductCategoryEntity getProductCategoryById(int id);
    ProductCategoryEntity getProductCategoryByName(String name);
    void addProductCategory(String name);
    void editCategory(ProductCategoryEntity category);
}
