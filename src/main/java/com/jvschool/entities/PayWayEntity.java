package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "PAY_WAY", schema = "MYSHOP_SCHEMA")
public class PayWayEntity  implements Serializable {
    private int payWayId;
    private String payWayName;

    @Id
    @Column(name = "PAY_WAY_ID", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getPayWayId() {
        return payWayId;
    }

    public void setPayWayId(int payWayId) {
        this.payWayId = payWayId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 50)
    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayWayEntity that = (PayWayEntity) o;

        if (payWayId != that.payWayId) return false;
        if (payWayName != null ? !payWayName.equals(that.payWayName) : that.payWayName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = payWayId;
        result = 31 * result + (payWayName != null ? payWayName.hashCode() : 0);
        return result;
    }
}
