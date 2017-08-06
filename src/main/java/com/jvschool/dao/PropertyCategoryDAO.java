package com.jvschool.dao;

import com.jvschool.entities.PropertyCategoryEntity;

import java.util.List;


public interface PropertyCategoryDAO {
    List<PropertyCategoryEntity> getAllProductCategories();
    PropertyCategoryEntity getProductCategoryById(int id);
}
