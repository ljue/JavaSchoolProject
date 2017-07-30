package com.jvschool.svc.api;

import com.jvschool.entities.ProductEntity;
import com.jvschool.dto.ProductAttribute;

import java.util.List;
import java.util.Set;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface ProductService {

    void addProduct(ProductEntity productEntity);
    ProductAttribute getProductAttributeById(long id);
    ProductEntity getProductById(long id);
    List<ProductAttribute> getAllProducts();
    List<ProductAttribute> getProductsToBuy(Set<Long> list);

}
