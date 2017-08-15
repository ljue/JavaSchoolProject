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
@Table(name = "PROPERTY", schema = "MYSHOP_SCHEMA")
public class PropertyEntity implements Serializable {

    @Id
    @Column(name = "PROPERTY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyId;

    @Basic
    @Column(name = "NAME")
    private String propertyName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROPERTY_GROUP_ID")
    private PropertyGroupEntity propertyGroup;

}