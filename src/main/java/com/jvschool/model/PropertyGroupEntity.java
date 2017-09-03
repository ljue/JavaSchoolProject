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
@Table(name = "PROPERTY_GROUP", schema = "MYSHOP_SCHEMA")
public class PropertyGroupEntity implements Serializable {

    @Id
    @Column(name = "PROPERTY_GROUP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyGroupId;

    @Basic
    @Column(name = "NAME")
    private String propertyGroupName;

    @Basic
    @Column(name = "SOLO")
    private boolean solo;

}
