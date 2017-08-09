package com.jvschool.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "PROPERTY_GROUP", schema = "MYSHOP_SCHEMA")
public class PropertyCategoryEntity  implements Serializable {

    @Id
    @Column(name = "PROPERTY_GROUP_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propCatId;

    @Basic
    @Column(name = "NAME")
    private String propCatName;

}
