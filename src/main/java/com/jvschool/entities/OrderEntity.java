package com.jvschool.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ORDER", schema = "MYSHOP_SCHEMA")
public class OrderEntity {

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Basic
    @Column(name = "TIME", nullable = false)
    private Timestamp dateTimeOrder;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "USER_ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "PAY_WAY_ID", referencedColumnName = "PAY_WAY_ID", nullable = false)
    private PayWayEntity payWay;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "DELIVERY_STATUS_ID", referencedColumnName = "DELIVERY_STATUS_ID")
    private DeliveryStatusEntity deliveryStatus;

    @ManyToOne
    @JoinColumn(name = "DELIVERY_WAY_ID", referencedColumnName = "DELIVERY_WAY_ID", nullable = false)
    private DeliveryWayEntity deliveryWay;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private List<BucketEntity> buckets = new ArrayList<>();

}
