package com.jvschool.dao;

import com.jvschool.entities.ProductEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface ProductDAO {

    void addProduct(ProductEntity productEntity);
    ProductEntity getProductById(long id);
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProductsToBuy(Set<Long> list);
    List<ProductEntity> getTopProducts();

}
