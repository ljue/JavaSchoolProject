package com.jvschool.svc;

import com.jvschool.entities.ProductEntity;
import com.jvschool.util.Attributes.FilterAttribute;
import com.jvschool.util.Attributes.ProductAttribute;

import java.util.List;
import java.util.Set;


public interface ProductService {

    void addProduct(ProductEntity productEntity);
    ProductAttribute getProductAttributeById(long id);
    ProductEntity getProductById(long id);
    List<ProductAttribute> getAllProducts();
    List<ProductAttribute> getProductsByCategory(String category);
    List<ProductAttribute> getProductsToBuy(Set<Long> list);
    List<ProductAttribute> getTopProducts();
    List<ProductAttribute> getProductsWithFilter(FilterAttribute filterAttribute);

}
