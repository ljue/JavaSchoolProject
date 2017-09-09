package com.jvschool.dao.api;

import com.jvschool.model.CategoryEntity;
import com.jvschool.model.ProductEntity;
import com.jvschool.dto.FilterAttribute;

import java.util.List;
import java.util.Map;


public interface ProductDAO {

    void addProduct(ProductEntity productEntity);
    void editProductInfo(ProductEntity productEntity);
    void removeProductById(long id);
    void returnProductById(long id);
    ProductEntity getProductById(long id);
    long getPictureIdByPicName(String name);
    List<ProductEntity> getAllProducts();
    List<ProductEntity> getProductsByCategory(CategoryEntity category);
    List<ProductEntity> getTopProducts();
    List<ProductEntity> getProductsWithFilter(FilterAttribute filterAttribute);
    long getCountProducts();
    boolean setMinusCountProducts(Map<Long, Integer> map);
    List<ProductEntity> getProductsFromTo(int page, int count);

    List<ProductEntity> getTopProductsForOneProduct(long productId);


}
