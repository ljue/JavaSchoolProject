package com.jvschool.svc.api;

import com.jvschool.model.ProductEntity;
import com.jvschool.dto.FilterAttribute;
import com.jvschool.dto.ProductAttribute;

import java.util.List;
import java.util.Map;


public interface ProductService {

    /**
     * Gets product {@link ProductEntity} by id, converts it to dto {@link ProductAttribute} and returns it.
     * @param id
     * @return order dto
     */
    ProductAttribute getProductAttributeById(long id);

    /**
     * Gets product {@link ProductEntity} by id.
     * @param id
     * @return product entity
     */
    ProductEntity getProductById(long id);

    /**
     * Gets picture {@link com.jvschool.model.PicturesEntity} by name.
     * @param name
     * @return
     */
    long getPictureIdByPicName(String name);

    /**
     * Gets list of all products {@link ProductEntity} sorted by popular,
     * converts it to list of products dto {@link ProductAttribute} and returns it.
     * @return list of product dto.
     */
    List<ProductAttribute> getAllProducts();

    /**
     * Gets list of products {@link ProductEntity} with category name as in param,
     * converts it to list of products dto {@link ProductAttribute} and returns it.
     * @param category
     * @return
     */
    List<ProductAttribute> getProductsByCategory(String category);

    /**
     * Get list of top (max 10) products {@link ProductEntity},
     * transforms it to list of products dto {@link ProductAttribute} and returns it.
     * @return
     */
    List<ProductAttribute> getTopProducts();

    /**
     * Gets list of products {@link ProductEntity} which were filtered,
     * converts it to list of products dto {@link ProductAttribute} and returns it.
     * @param filterAttribute
     * @return
     */
    List<ProductAttribute> getProductsWithFilter(FilterAttribute filterAttribute);

    /**
     * Converts product dto {@link ProductAttribute} to new product {@link ProductEntity} and saves it in database.
     * @param productAttribute
     */
    void addProduct(ProductAttribute productAttribute);


    /**
     * Gets count of visible products {@link ProductEntity}.
     * @return
     */
    long getCountProducts();

    /**
     *  Gets list of products {@link ProductEntity} sorted by popular,
     *  converts it to list of products dto {@link ProductAttribute}.
     *  list.size() = count. products indexes are in [ (page - 1) * count, page * count]
     * @param page in catalog
     * @param count products on page
     * @return list of products dto
     */
    List<ProductAttribute> getProductsFromTo(int page, int count);


    /**
     *  Gets list of products {@link ProductEntity} with filter {@link FilterAttribute}
     *  sorted by popular and converts it to list of products dto {@link }.
     *  list.size() = count. products indexes are in [ (page - 1) * count, page * count]
     * @param page
     * @param count
     * @return list of products dto
     */
    Map<Integer, List<ProductAttribute>> getProductsByFilterFromTo(int page, int count, FilterAttribute filterAttribute);

    /**
     * Gets list of products {@link ProductEntity}
     * which were bought with product with {@link ProductEntity#productId} = param.
     * If its size less than 6, method gets list of product by same category {@link com.jvschool.model.CategoryEntity}
     * and puts missing elements.
     * Than converts it to list of product dto {@link ProductAttribute}
     * @param productId
     * @return list of product dto
     */
    List<ProductAttribute> getTopProductsForOneProduct(long productId);

    /**
     * Creates new product {@link ProductEntity}. Sets new data about category, cost, adding count for product.
     * And calls {@link com.jvschool.dao.api.ProductDAO#editProductInfo(ProductEntity)} to edit product info.
     * @param productAttribute
     */
    void editProductInfo(ProductAttribute productAttribute);

    /**
     * Calls {@link com.jvschool.dao.api.ProductDAO#removeProductById(long)} to set visible = false.
     * @param id
     */
    void removeProductById(long id);

    /**
     * Calls {@link com.jvschool.dao.api.ProductDAO#removeProductById(long)} to set visible = true.
     * @param id
     */
    void returnProductById(long id);

    /**
     * For each product {@link ProductEntity} by id = entry.key sets count = count-entry.value
     * If each count > suitable entry.value
     * @param map
     * @return
     */
    boolean setMinusCountProducts(Map<Long, Integer> map);

}
