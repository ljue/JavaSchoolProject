package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Людмила on 19.07.2017.
 */
@Entity
@Table(name = "DeliveryWay", schema = "myshop_schema")
public class DeliveryWayEntity implements Serializable {
    private int deliveryWayId;
    private String deliveryWayName;

    @Id
    @Column(name = "DeliveryWayId", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getDeliveryWayId() {
        return deliveryWayId;
    }

    public void setDeliveryWayId(int deliveryStatusId) {
        this.deliveryWayId = deliveryStatusId;
    }

    @Basic
    @Column(name = "DeliveryWayName", nullable = false, length = 50)
    public String getDeliveryWayName() {
        return deliveryWayName;
    }

    public void setDeliveryWayName(String deliveryStatusName) {
        this.deliveryWayName = deliveryStatusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeliveryWayEntity that = (DeliveryWayEntity) o;

        if (deliveryWayId != that.deliveryWayId) return false;
        if (deliveryWayName != null ? !deliveryWayName.equals(that.deliveryWayName) : that.deliveryWayName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deliveryWayId;
        result = 31 * result + (deliveryWayName != null ? deliveryWayName.hashCode() : 0);
        return result;
    }
}
