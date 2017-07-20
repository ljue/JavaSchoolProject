package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Людмила on 19.07.2017.
 */
@Entity
@Table(name = "Order", schema = "myshop_schema")
public class OrderEntity implements Serializable {
    private long orderId;
    private long clientAddress;
    private Timestamp dateTimeOrder;
    private UserEntity clientByUserId;
    private DeliveryStatusEntity deliveryStatusByDeliveryStatus;
    private BucketEntity bucketByBucket;
    private PayStatusEntity payStatusByPayStatus;
    private PayWayEntity payWayByPayWay;

    @Id
    @Column(name = "OrderId", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "ClientAddress", nullable = false)
    public long getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(long clientAddress) {
        this.clientAddress = clientAddress;
    }

    @Basic
    @Column(name = "DateTimeOrder", nullable = false)
    public Timestamp getDateTimeOrder() {
        return dateTimeOrder;
    }

    public void setDateTimeOrder(Timestamp dateTimeOrder) {
        this.dateTimeOrder = dateTimeOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderId != that.orderId) return false;
        if (clientAddress != that.clientAddress) return false;
        if (dateTimeOrder != null ? !dateTimeOrder.equals(that.dateTimeOrder) : that.dateTimeOrder != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (int) (clientAddress ^ (clientAddress >>> 32));
        result = 31 * result + (dateTimeOrder != null ? dateTimeOrder.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ClientId", referencedColumnName = "Id", nullable = false)
    public UserEntity getClientByClientId() {
        return clientByUserId;
    }

    public void setClientByClientId(UserEntity clientByClientId) {
        this.clientByUserId = clientByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "DeliveryStatus", referencedColumnName = "DeliveryStatusId", nullable = false)
    public DeliveryStatusEntity getDeliveryStatusByDeliveryStatus() {
        return deliveryStatusByDeliveryStatus;
    }

    public void setDeliveryStatusByDeliveryStatus(DeliveryStatusEntity deliveryStatusByDeliveryStatus) {
        this.deliveryStatusByDeliveryStatus = deliveryStatusByDeliveryStatus;
    }

    @OneToOne
    @JoinColumn(name = "Bucket", referencedColumnName = "BucketId", nullable = false)
    public BucketEntity getBucketByBucket() {
        return bucketByBucket;
    }

    public void setBucketByBucket(BucketEntity bucketByBucket) {
        this.bucketByBucket = bucketByBucket;
    }


    @ManyToOne
    @JoinColumn(name = "PayStatus", referencedColumnName = "PayStatusId", nullable = false)
    public PayStatusEntity getPayStatusByPayStatus() {
        return payStatusByPayStatus;
    }

    public void setPayStatusByPayStatus(PayStatusEntity payStatusByPayStatus) {
        this.payStatusByPayStatus = payStatusByPayStatus;
    }

    @ManyToOne
    @JoinColumn(name = "PayWay", referencedColumnName = "PayWayId", nullable = false)
    public PayWayEntity getPayWayByPayWay() {
        return payWayByPayWay;
    }

    public void setPayWayByPayWay(PayWayEntity payWayByPayWay) {
        this.payWayByPayWay = payWayByPayWay;
    }

}
