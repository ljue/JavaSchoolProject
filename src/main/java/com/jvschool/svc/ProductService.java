package com.jvschool.svc;

import com.jvschool.entities.ProductEntity;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface ProductService {

    void addProduct(ProductEntity productEntity);
    ProductEntity getProductById(long id);

}
