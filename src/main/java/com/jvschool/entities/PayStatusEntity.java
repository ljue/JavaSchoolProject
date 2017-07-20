package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Людмила on 19.07.2017.
 */
@Entity
@Table(name = "PayStatus", schema = "myshop_schema")
public class PayStatusEntity  implements Serializable {
    private int payStatusId;
    private String payStatusName;

    @Id
    @Column(name = "PayStatusId", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getPayStatusId() {
        return payStatusId;
    }

    public void setPayStatusId(int payStatusId) {
        this.payStatusId = payStatusId;
    }

    @Basic
    @Column(name = "PayStatusName", nullable = false, length = 30)
    public String getPayStatusName() {
        return payStatusName;
    }

    public void setPayStatusName(String payStatusName) {
        this.payStatusName = payStatusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayStatusEntity that = (PayStatusEntity) o;

        if (payStatusId != that.payStatusId) return false;
        if (payStatusName != null ? !payStatusName.equals(that.payStatusName) : that.payStatusName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = payStatusId;
        result = 31 * result + (payStatusName != null ? payStatusName.hashCode() : 0);
        return result;
    }
}
