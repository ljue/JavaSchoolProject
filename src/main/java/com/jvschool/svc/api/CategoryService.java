package com.jvschool.svc.api;

import com.jvschool.model.CategoryEntity;
import com.jvschool.dto.CategoryAttribute;

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

    /**
     * Make category and all products in it unvisible.
     * @param category
     */
    void removeCategory(String category);

    /**
     * Gets all unvisible categories and return list of their names.
     * @return
     */
    List<String> getRemovedCategories();

    /**
     * Get category by name. Makes category visible. Makes all products in it visible if them were not removed later.
     * @param category
     */
    void returnCategory(String category);
}
