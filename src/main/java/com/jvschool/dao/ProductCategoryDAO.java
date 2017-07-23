package com.jvschool.dao;

import com.jvschool.entities.ProductCategoryEntity;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface ProductCategoryDAO {

    List<ProductCategoryEntity> getAllProductCategories();
    ProductCategoryEntity getProductCategoryById(int id);
    ProductCategoryEntity getProductCategoryByName(String name);
}
