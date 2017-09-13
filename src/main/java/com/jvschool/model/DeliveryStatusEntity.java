package com.jvschool.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "DELIVERY_STATUS", schema = "MYSHOP_SCHEMA")
public class DeliveryStatusEntity implements Serializable {

    @Id
    @Column(name = "DELIVERY_STATUS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryStatusId;

    @Basic
    @Column(name = "NAME", nullable = false)
    private String deliveryStatusName;

}
