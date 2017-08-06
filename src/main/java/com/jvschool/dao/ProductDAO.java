package com.jvschool.dao;

import com.jvschool.entities.ProductCategoryEntity;
import com.jvschool.entities.ProductEntity;
import com.jvschool.util.Attributes.FilterAttribute;

import java.util.List;
import java.util.Set;


public interface ProductDAO {

    void addProduct(ProductEntity productEntity);
    ProductEntity getProductById(long id);
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProductsByCategory(ProductCategoryEntity category);
    List<ProductEntity> getProductsToBuy(Set<Long> list);
    List<ProductEntity> getTopProducts();
    List<ProductEntity> getProductsWithFilter(FilterAttribute filterAttribute);

}
