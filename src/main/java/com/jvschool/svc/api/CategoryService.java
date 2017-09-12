package com.jvschool.svc.api;

import com.jvschool.model.CategoryEntity;
import com.jvschool.dto.CategoryAttribute;

import java.util.List;


public interface CategoryService {

    /**
     * Gets list of all visible product categories {@link CategoryEntity} and return list of their names.
     * @return list of names visible categories
     */
    List<String> getAllProductCategoryNames();

    /**
     * Calls {@link com.jvschool.dao.api.CategoryDAO#getProductCategoryByName(String)}
     * @param name
     * @return
     */
    CategoryEntity getProductCategoryByName(String name);

    /**
     * Calls {@link com.jvschool.dao.api.CategoryDAO#addProductCategory(String)}
     * @param name
     */
    void addProductCategory(String name);

    /**
     * Convert product category dto {@link CategoryAttribute} to product category entity and
     * calls {@link com.jvschool.dao.api.CategoryDAO#editCategory(CategoryEntity)}.
     * @param categoryAttribute
     */
    void editCategory(CategoryAttribute categoryAttribute);

    /**
     * Make category and all products in it invisible.
     * @param category
     */
    void removeCategory(String category);

    /**
     * Gets all invisible categories and return list of their names.
     * @return
     */
    List<String> getRemovedCategories();

    /**
     * Get category by name. Makes category visible. Makes all products in it visible if them were not removed later.
     * @param category
     */
    void returnCategory(String category);


}
