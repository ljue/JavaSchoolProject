package com.jvschool.dao;

import com.jvschool.entities.PropertyCategoryEntity;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface PropertyCategoryDAO {
    List<PropertyCategoryEntity> getAllProductCategories();
    PropertyCategoryEntity getProductCategoryById(int id);
}
