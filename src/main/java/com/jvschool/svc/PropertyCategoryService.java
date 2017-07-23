package com.jvschool.svc;

import com.jvschool.entities.PropertyCategoryEntity;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface PropertyCategoryService {
    List<PropertyCategoryEntity> getAllProperyCategories();
    PropertyCategoryEntity getProductCategoryById(int id);
}
