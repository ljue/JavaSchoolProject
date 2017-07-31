package com.jvschool.util.Attributes;


import com.jvschool.entities.BucketEntity;
import com.jvschool.entities.OrderEntity;
import com.jvschool.entities.ProductEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 27.07.2017.
 */
public class OrderAttribute {

    private long orderId;
    private Timestamp dateTimeOrder;
    private Long userId;
    private Long addressId;
    private String payWay;
    private String deliveryStatus;
    private String deliveryWay;
    //private List<Long> products = new ArrayList<>();
    private List<BucketAttribute> buckets = new ArrayList<>();



    public OrderAttribute() {}

    public OrderAttribute(OrderEntity oe) {
        this.orderId = oe.getOrderId();
        this.dateTimeOrder = oe.getDateTimeOrder();
        this.userId = oe.getUser().getId();
        this.addressId = oe.getAddress().getAddressId();
        this.payWay = oe.getPayWay().getPayWayName();
        this.deliveryStatus = oe.getDeliveryStatus().getDeliveryStatusName();
        this.deliveryWay = oe.getDeliveryWay().getDeliveryWayName();

        List<BucketEntity> lbe = oe.getBuckets();
        if(!lbe.isEmpty()) {
            for (BucketEntity be:lbe) {
                this.buckets.add(new BucketAttribute(be));
            }
        }
//        List<ProductEntity> lpe = oe.getProducts();
//        if(!lpe.isEmpty()) {
//            for(ProductEntity pe:lpe) {
//                products.add(pe.getProductId());
//            }
//        }
    }



    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(Timestamp dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryWay() {
        return deliveryWay;
    }

    public void setDeliveryWay(String deliveryWay) {
        this.deliveryWay = deliveryWay;
    }

    public List<BucketAttribute> getBuckets() {
        return buckets;
    }

    public void setBuckets(List<BucketAttribute> buckets) {
        this.buckets = buckets;
    }

    //    public List<Long> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Long> products) {
//        this.products = products;
//    }
}
