package com.jvschool.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "PROPERTY", schema = "MYSHOP_SCHEMA")
public class ProductPropertyEntity  implements Serializable {

    @Id
    @Column(name = "PROPERTY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodPropId;

    @Basic
    @Column(name = "NAME")
    private String prodPropName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROPERTY_GROUP_ID")
    private PropertyCategoryEntity propertyCategoryByProdPropCatId;

}
