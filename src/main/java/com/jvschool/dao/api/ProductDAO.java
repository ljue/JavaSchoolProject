package com.jvschool.dao.api;

import com.jvschool.model.CategoryEntity;
import com.jvschool.model.ProductEntity;
import com.jvschool.dto.FilterAttribute;

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

    List<ProductEntity> getTopProductsForOneProduct(long productId);


}
