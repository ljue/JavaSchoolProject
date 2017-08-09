package com.jvschool.svc;

import com.jvschool.entities.CategoryEntity;
import com.jvschool.util.Attributes.CategoryAttribute;

import java.util.List;


public interface CategoryService {

    List<String> getAllProductCategoryNames();
    CategoryEntity getProductCategoryByName(String name);
    void addProductCategory(String name);
    void editCategory(CategoryAttribute categoryAttribute);
}
