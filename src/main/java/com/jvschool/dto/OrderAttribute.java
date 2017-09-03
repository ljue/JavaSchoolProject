package com.jvschool.dto;


import com.jvschool.model.BucketEntity;
import com.jvschool.model.OrderEntity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class OrderAttribute {

    private long orderId;
    private Timestamp dateTimeOrder;
    private Long userId;
    private Long addressId;
    private String payWay;
    private String deliveryStatus;
    private String deliveryWay;
    private List<BucketAttribute> buckets = new ArrayList<>();



    public OrderAttribute() {}

    public OrderAttribute(OrderEntity oe) {
        this.orderId = oe.getOrderId();
        this.dateTimeOrder = oe.getDateTimeOrder();
        this.userId = oe.getUser().getId();
        this.addressId = oe.getAddress().getAddressId();
        this.payWay = oe.getPayWay().getPayWayName();
        this.deliveryWay = oe.getDeliveryWay().getDeliveryWayName();

        if(oe.getDeliveryStatus()==null) {
            this.deliveryStatus = "Await";
        }
        else
            this.deliveryStatus = oe.getDeliveryStatus().getDeliveryStatusName();

        List<BucketEntity> lbe = oe.getBuckets();
        if(!lbe.isEmpty()) {
            for (BucketEntity be:lbe) {
                this.buckets.add(new BucketAttribute(be));
            }
        }
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

}
