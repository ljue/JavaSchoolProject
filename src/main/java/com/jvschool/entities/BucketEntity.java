package com.jvschool.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "BUCKET", schema = "MYSHOP_SCHEMA")
public class BucketEntity implements Serializable {

    @Id
    @Column(name = "BUCKET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bucketId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productId;

    @Basic
    @Column(name = "COUNT_PRODUCT")
    private int countProduct;

    @Basic
    @Column(name = "COST_PRODUCT")
    private double costProduct;

    @Basic
    @Column(name = "ORDER_ID")
    private long orderId;

}
