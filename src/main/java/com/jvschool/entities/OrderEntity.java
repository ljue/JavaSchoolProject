package com.jvschool.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Людмила on 22.07.2017.
 */
@Entity
@Table(name = "Order", schema = "myshop_schema")
public class OrderEntity {
    private long orderId;
    private Timestamp dateTimeOrder;

    private UserEntity userByClientId;
    private AddressEntity addressByClientAddress;
    private PayWayEntity payWayByPayWay;
    private PayStatusEntity payStatusByPayStatus;
    private DeliveryStatusEntity deliveryStatusByDeliveryStatus;
   // private Collection<ProductEntity> productByProductId;

    @Id
    @Column(name = "OrderId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
    @JoinColumn(name = "ClientId", referencedColumnName = "Id", nullable = false)
    public UserEntity getUserByClientId() {
        return userByClientId;
    }

    public void setUserByClientId(UserEntity userByClientId) {
        this.userByClientId = userByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "ClientAddress", referencedColumnName = "AddressId", nullable = false)
    public AddressEntity getAddressByClientAddress() {
        return addressByClientAddress;
    }

    public void setAddressByClientAddress(AddressEntity addressByClientAddress) {
        this.addressByClientAddress = addressByClientAddress;
    }

    @ManyToOne
    @JoinColumn(name = "PayWay", referencedColumnName = "PayWayId", nullable = false)
    public PayWayEntity getPayWayByPayWay() {
        return payWayByPayWay;
    }

    public void setPayWayByPayWay(PayWayEntity payWayByPayWay) {
        this.payWayByPayWay = payWayByPayWay;
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
    @JoinColumn(name = "DeliveryStatus", referencedColumnName = "DeliveryStatusId", nullable = false)
    public DeliveryStatusEntity getDeliveryStatusByDeliveryStatus() {
        return deliveryStatusByDeliveryStatus;
    }

    public void setDeliveryStatusByDeliveryStatus(DeliveryStatusEntity deliveryStatusByDeliveryStatus) {
        this.deliveryStatusByDeliveryStatus = deliveryStatusByDeliveryStatus;
    }

//    @OneToMany(mappedBy = "bucketByProductId")
//    public Collection<ProductEntity> getBucketsByProductId() {
//        return productByProductId;
//    }
//
//    public void setBucketsByProductId(Collection<ProductEntity> productByProductId) {
//        this.productByProductId = productByProductId;
//    }
}
