package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "DELIVERY_STATUS", schema = "MYSHOP_SCHEMA")
public class DeliveryStatusEntity implements Serializable {
    private int deliveryStatusId;
    private String deliveryStatusName;

    @Id
    @Column(name = "DELIVERY_STATUS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(int payStatusId) {
        this.deliveryStatusId = payStatusId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 30)
    public String getDeliveryStatusName() {
        return deliveryStatusName;
    }

    public void setDeliveryStatusName(String payStatusName) {
        this.deliveryStatusName = payStatusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryStatusEntity that = (DeliveryStatusEntity) o;

        if (deliveryStatusId != that.deliveryStatusId) return false;
        if (deliveryStatusName != null ? !deliveryStatusName.equals(that.deliveryStatusName) : that.deliveryStatusName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliveryStatusId;
        result = 31 * result + (deliveryStatusName != null ? deliveryStatusName.hashCode() : 0);
        return result;
    }
}
