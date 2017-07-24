package com.jvschool.svc;

import com.jvschool.entities.ProductCategoryEntity;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface ProductCategoryService {
    List<ProductCategoryEntity> getAllProductCategories();
    ProductCategoryEntity getProductCategoryById(int id);
    ProductCategoryEntity getProductCategoryByName(String name);
    void addProductCategory(String name);
    void editCategory(ProductCategoryEntity category);
}