package com.jvschool.svc;

import com.jvschool.entities.ProductEntity;
import com.jvschool.util.ProductAttribute;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface ProductService {

    void addProduct(ProductEntity productEntity);
    ProductEntity getProductById(long id);
    List<ProductAttribute> getAllProducts();
    List<ProductAttribute> getProductsToBuy(List<Long> list);

}
