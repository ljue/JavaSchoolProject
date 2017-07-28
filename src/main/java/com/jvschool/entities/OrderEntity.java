package com.jvschool.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 22.07.2017.
 */
@Entity
@Table(name = "Order", schema = "myshop_schema")
public class OrderEntity {
    private long orderId;
    private Timestamp dateTimeOrder;

    private UserEntity user;
    private AddressEntity address;
    private PayWayEntity payWay;
    private DeliveryStatusEntity deliveryStatus;
    private DeliveryWayEntity deliveryWay;
    private List<ProductEntity> products = new ArrayList<>();

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
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userByClientId) {
        this.user = userByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "UserAddress", referencedColumnName = "AddressId", nullable = false)
    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity addressByClientAddress) {
        this.address = addressByClientAddress;
    }

    @ManyToOne
    @JoinColumn(name = "PayWay", referencedColumnName = "PayWayId", nullable = false)
    public PayWayEntity getPayWay() {
        return payWay;
    }

    public void setPayWay(PayWayEntity payWayByPayWay) {
        this.payWay = payWayByPayWay;
    }

    @ManyToOne
    @JoinColumn(name = "DeliveryStatus", referencedColumnName = "DeliveryStatusId", nullable = false)
    public DeliveryStatusEntity getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatusEntity payStatusByPayStatus) {
        this.deliveryStatus = payStatusByPayStatus;
    }

    @ManyToOne
    @JoinColumn(name = "DeliveryWay", referencedColumnName = "DeliveryWayId", nullable = false)
    public DeliveryWayEntity getDeliveryWay() {
        return deliveryWay;
    }

    public void setDeliveryWay(DeliveryWayEntity deliveryStatusByDeliveryStatus) {
        this.deliveryWay = deliveryStatusByDeliveryStatus;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Order_Product",
    joinColumns = @JoinColumn(name = "OrderId", referencedColumnName = "OrderId"),
    inverseJoinColumns = @JoinColumn(name = "ProductId", referencedColumnName = "ProductId"))
    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> productByProductId) {
        this.products = productByProductId;
    }


}
