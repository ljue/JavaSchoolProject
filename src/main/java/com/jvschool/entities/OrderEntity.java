package com.jvschool.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ORDER", schema = "MYSHOP_SCHEMA")
public class OrderEntity {
    private long orderId;
    private Timestamp dateTimeOrder;
    private UserEntity user;
    private AddressEntity address;
    private PayWayEntity payWay;
    private DeliveryStatusEntity deliveryStatus;
    private DeliveryWayEntity deliveryWay;
    private List<BucketEntity> buckets = new ArrayList<>();

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    @Basic
    @Column(name = "TIME", nullable = false)
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
        if (dateTimeOrder != null ? !dateTimeOrder.equals(that.dateTimeOrder) : that.dateTimeOrder != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (orderId ^ (orderId >>> 32));
        result = 31 * result + (dateTimeOrder != null ? dateTimeOrder.hashCode() : 0);
        return result;
    }


    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userByClientId) {
        this.user = userByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity addressByClientAddress) {
        this.address = addressByClientAddress;
    }

    @ManyToOne
    @JoinColumn(name = "PAY_WAY_ID", referencedColumnName = "PAY_WAY_ID", nullable = false)
    public PayWayEntity getPayWay() {
        return payWay;
    }

    public void setPayWay(PayWayEntity payWayByPayWay) {
        this.payWay = payWayByPayWay;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DELIVERY_STATUS_ID", referencedColumnName = "DELIVERY_STATUS_ID")
    public DeliveryStatusEntity getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatusEntity payStatusByPayStatus) {
        this.deliveryStatus = payStatusByPayStatus;
    }

    @ManyToOne
    @JoinColumn(name = "DELIVERY_WAY_ID", referencedColumnName = "DELIVERY_WAY_ID", nullable = false)
    public DeliveryWayEntity getDeliveryWay() {
        return deliveryWay;
    }

    public void setDeliveryWay(DeliveryWayEntity deliveryStatusByDeliveryStatus) {
        this.deliveryWay = deliveryStatusByDeliveryStatus;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    public List<BucketEntity> getBuckets() {
        return buckets;
    }

    public void setBuckets(List<BucketEntity> buckets) {
        this.buckets = buckets;
    }

}
