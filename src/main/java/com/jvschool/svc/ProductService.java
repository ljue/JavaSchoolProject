package com.jvschool.svc;

import com.jvschool.entities.ProductEntity;
import com.jvschool.util.Attributes.FilterAttribute;
import com.jvschool.util.Attributes.ProductAttribute;

import java.util.List;
import java.util.Set;


public interface ProductService {

    ProductAttribute getProductAttributeById(long id);
    ProductEntity getProductById(long id);
    List<ProductAttribute> getAllProducts();
    List<ProductAttribute> getProductsByCategory(String category);
    List<ProductAttribute> getTopProducts();
    List<ProductAttribute> getProductsWithFilter(FilterAttribute filterAttribute);
    void addProduct(ProductAttribute productAttribute);

}
