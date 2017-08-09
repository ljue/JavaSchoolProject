package com.jvschool.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "DELIVERY_WAY", schema = "MYSHOP_SCHEMA")
public class DeliveryWayEntity implements Serializable {

    @Id
    @Column(name = "DELIVERY_WAY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryWayId;

    @Basic
    @Column(name = "NAME", nullable = false)
    private String deliveryWayName;

}
