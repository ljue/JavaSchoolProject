package com.jvschool.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "PRODUCT", schema = "MYSHOP_SCHEMA")
public class ProductEntity  implements Serializable {

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @Basic
    @Column(name = "NAME", nullable = false)
    private String productName;

    @Basic
    @Column(name = "COUNT", nullable = false)
    private int count;

    @Basic
    @Column(name = "COST", nullable = false)
    private double cost;

    @Basic
    @Column(name = "SIZE")
    private String size;

    @Basic
    @Column(name = "BATTERY")
    private String battery;

    @Basic
    @Column(name = "FLY_TIME")
    private int flyTime;

    @Basic
    @Column(name = "DISTANCE")
    private int distance;

    @Basic
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID", nullable = false)
    private CategoryEntity category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    private List<PicturesEntity> pictures = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PRODUCT_HAS_PROPERTY",
            joinColumns = @JoinColumn(name = "PRODUCT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROPERTY_ID"))
    private Set<PropertyEntity> properties = new HashSet<>();

}
