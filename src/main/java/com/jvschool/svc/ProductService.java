package com.jvschool.svc;

import com.jvschool.entities.ProductEntity;
import com.jvschool.util.Attributes.FilterAttribute;
import com.jvschool.util.Attributes.ProductAttribute;

import java.util.List;


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
     * Get list of all products and transform it to list of products dto.
     * @return
     */
    List<ProductAttribute> getAllProducts();

    /**
     * Get list of products entities with category name as in param
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

}
