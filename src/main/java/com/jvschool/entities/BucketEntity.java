package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "BUCKET", schema = "MYSHOP_SCHEMA")
public class BucketEntity implements Serializable {

    private int bucketId;
    private ProductEntity productId;
    private int countProduct;
    private long orderId;


    @Id
    @Column(name = "BUCKET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBucketId() {
        return bucketId;
    }

    public void setBucketId(int bucketId) {
        this.bucketId = bucketId;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRODUCT_ID")
    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "COUNT_PRODUCT")
    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    @Basic
    @Column(name = "ORDER_ID")
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BucketEntity)) return false;

        BucketEntity that = (BucketEntity) o;

        if (bucketId != that.bucketId) return false;
        if (countProduct != that.countProduct) return false;
        if (orderId != that.orderId) return false;
        return productId != null ? productId.equals(that.productId) : that.productId == null;
    }

    @Override
    public int hashCode() {
        int result = bucketId;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + countProduct;
        result = 31 * result + (int) (orderId ^ (orderId >>> 32));
        return result;
    }
}
