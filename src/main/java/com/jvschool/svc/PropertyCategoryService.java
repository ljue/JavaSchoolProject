package com.jvschool.svc;

import com.jvschool.entities.PropertyCategoryEntity;

import java.util.List;


public interface PropertyCategoryService {
    List<PropertyCategoryEntity> getAllPropertyCategories();
    PropertyCategoryEntity getProductCategoryById(int id);
}
