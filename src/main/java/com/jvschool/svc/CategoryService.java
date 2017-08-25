package com.jvschool.svc;

import com.jvschool.entities.CategoryEntity;
import com.jvschool.util.Attributes.CategoryAttribute;

import java.util.List;


public interface CategoryService {

    /**
     * Get list of all product categories and return list of their names.
     * @return
     */
    List<String> getAllProductCategoryNames();

    /**
     * Get product category entity by name.
     * @param name
     * @return
     */
    CategoryEntity getProductCategoryByName(String name);

    /**
     * Create new product category entity with such name and save it in database.
     * @param name
     */
    void addProductCategory(String name);

    /**
     * Convert product category dto to product category entity and merge it in database.
     * @param categoryAttribute
     */
    void editCategory(CategoryAttribute categoryAttribute);
}
