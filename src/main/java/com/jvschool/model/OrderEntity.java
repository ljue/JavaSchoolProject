package com.jvschool.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ORDERS", schema = "MYSHOP_SCHEMA")
public class OrderEntity implements Serializable {

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Basic
    @Column(name = "TIME", nullable = false)
    private Date dateTimeOrder;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "USER_ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "PAY_WAY_ID", referencedColumnName = "PAY_WAY_ID", nullable = false)
    private PayWayEntity payWay;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "DELIVERY_STATUS_ID", referencedColumnName = "DELIVERY_STATUS_ID")
    private DeliveryStatusEntity deliveryStatus;

    @ManyToOne
    @JoinColumn(name = "DELIVERY_WAY_ID", referencedColumnName = "DELIVERY_WAY_ID", nullable = false)
    private DeliveryWayEntity deliveryWay;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_ID")
    private List<BucketEntity> buckets = new ArrayList<>();

}
