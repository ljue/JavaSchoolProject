package com.jvschool.dao;

import com.jvschool.entities.CategoryEntity;
import com.jvschool.entities.ProductEntity;
import com.jvschool.util.Attributes.FilterAttribute;

import java.util.List;



public interface ProductDAO {

    void addProduct(ProductEntity productEntity);
    ProductEntity getProductById(long id);
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProductsByCategory(CategoryEntity category);
    List<ProductEntity> getTopProducts();
    List<ProductEntity> getProductsWithFilter(FilterAttribute filterAttribute);
    long getCountProducts();
    List<ProductEntity> getProductsFromTo(int page, int count);


}
