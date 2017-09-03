package com.jvschool.svc.api;

import com.jvschool.model.ProductEntity;
import com.jvschool.dto.FilterAttribute;
import com.jvschool.dto.ProductAttribute;

import java.util.List;
import java.util.Map;


public interface ProductService {

    /**
     * Get product entity by id and transform it to dto.
     * @param id
     * @return
     */
    ProductAttribute getProductAttributeById(long id);

    /**
     * Get product entity by id.
     * @param id
     * @return
     */
    ProductEntity getProductById(long id);

    /**
     * Get list of all products sorted by popular and transform it to list of products dto.
     * @return
     */
    List<ProductAttribute> getAllProducts();

    /**
     * Get list of products model with category name as in param
     * and transform it to list of products dto.
     * @param category
     * @return
     */
    List<ProductAttribute> getProductsByCategory(String category);

    /**
     * Get list of top products and transform it to list of products dto.
     * @return
     */
    List<ProductAttribute> getTopProducts();

    /**
     * Get list of products which were filtered and transform it to list of products dto.
     * @param filterAttribute
     * @return
     */
    List<ProductAttribute> getProductsWithFilter(FilterAttribute filterAttribute);

    /**
     * Transform product dto to new product entity and save it in database.
     * @param productAttribute
     */
    void addProduct(ProductAttribute productAttribute);


    /**
     * Get count of products.
     * @return
     */
    long getCountProducts();

    /**
     *  Get list of products sorted by popular and transform it to list of products dto.
     *  list.size = count and products "popular" indexes are in [ (page - 1) * count, page * count - 1]
     * @param page
     * @param count
     * @return
     */
    List<ProductAttribute> getProductsFromTo(int page, int count);


    /**
     *  Get list of products with filter sorted by popular and transform it to list of products dto.
     *  list.size = count and products "popular" indexes are in [ (page - 1) * count, page * count - 1]
     * @param page
     * @param count
     * @return
     */
    Map<Integer, List<ProductAttribute>> getProductsByFilterFromTo(int page, int count, FilterAttribute filterAttribute);

}
