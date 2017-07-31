package com.jvschool.util.Attributes;

import com.jvschool.entities.BucketEntity;
import com.jvschool.entities.ProductEntity;

/**
 * Created by Людмила on 31.07.2017.
 */
public class BucketAttribute {

    private int bucketId;
    private long productId;
    private int countProduct;
    private long orderId;

    public BucketAttribute() {}

    public BucketAttribute(BucketEntity bucketEntity) {
        this.bucketId = bucketEntity.getBucketId();
        this.productId = bucketEntity.getProductId().getProductId();
        this.countProduct = bucketEntity.getCountProduct();
        this.orderId = bucketEntity.getOrderId();
    }

    public int getBucketId() {
        return bucketId;
    }

    public void setBucketId(int bucketId) {
        this.bucketId = bucketId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
