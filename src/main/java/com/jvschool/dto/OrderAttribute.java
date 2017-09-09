package com.jvschool.dto;


import com.jvschool.model.BucketEntity;
import com.jvschool.model.OrderEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class OrderAttribute implements Serializable {

    private long orderId;
    private Date dateTimeOrder;
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


}
