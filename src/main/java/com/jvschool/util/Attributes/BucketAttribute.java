package com.jvschool.util.Attributes;

import com.jvschool.entities.BucketEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BucketAttribute {

    private int bucketId;
    private long productId;
    private int countProduct;
    private double costProduct;
    private long orderId;


    public BucketAttribute() {}

    public BucketAttribute(BucketEntity bucketEntity) {
        this.bucketId = bucketEntity.getBucketId();
        this.productId = bucketEntity.getProductId().getProductId();
        this.countProduct = bucketEntity.getCountProduct();
        this.costProduct = bucketEntity.getCostProduct();
        this.orderId = bucketEntity.getOrderId();

    }
}
