package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Людмила on 19.07.2017.
 */
@Entity
@Table(name = "DeliveryStatus", schema = "myshop_schema")
public class DeliveryStatusEntity implements Serializable {
    private int deliveryStatusId;
    private String deliveryStatusName;

    @Id
    @Column(name = "DeliveryStatusId", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(int deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
    }

    @Basic
    @Column(name = "DeliveryStatusName", nullable = false, length = 50)
    public String getDeliveryStatusName() {
        return deliveryStatusName;
    }

    public void setDeliveryStatusName(String deliveryStatusName) {
        this.deliveryStatusName = deliveryStatusName;
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
