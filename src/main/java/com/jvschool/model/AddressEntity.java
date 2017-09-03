package com.jvschool.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ADDRESS", schema = "MYSHOP_SCHEMA")
public class AddressEntity implements Serializable {

    @Id
    @Column(name = "ADDRESS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;

    @Basic
    @Column(name = "STREET_ADDRESS", nullable = false)
    private String streetAddress;

    @Basic
    @Column(name = "POST_INDEX", nullable = false)
    private String postIndex;

    @Basic
    @Column(name = "USER_ID")
    private Long userId;

    @Basic
    @Column(name = "COUNTRY")
    private String country;

    @Basic
    @Column(name = "REGION")
    private String region;

    @Basic
    @Column(name = "CITY")
    private String city;

    @Basic
    @Column(name = "VISIBLE")
    private boolean visible;

}
