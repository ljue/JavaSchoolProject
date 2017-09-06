package com.jvschool.dto;

import com.jvschool.model.BucketEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Locale;


@Getter
@Setter
public class BucketAttribute {

    private int bucketId;
    private long productId;
    private int countProduct;
    private String costProduct;
    private long orderId;


    public BucketAttribute() {}

    public BucketAttribute(BucketEntity bucketEntity) {
        this.bucketId = bucketEntity.getBucketId();
        this.productId = bucketEntity.getProductId().getProductId();
        this.countProduct = bucketEntity.getCountProduct();
        this.costProduct = String.format(Locale.US, "%.2f", bucketEntity.getCostProduct());
        this.orderId = bucketEntity.getOrderId();
    }
}
