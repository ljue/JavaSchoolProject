package com.jvschool.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

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

    //@ManyToMany(cascade = CascadeType.ALL)//, fetch = FetchType.EAGER)//(fetch = FetchType.LAZY)//(mappedBy = "product")
//    @JoinTable(roleName = "Prod_Prop",
//            joinColumns = @JoinColumn(roleName = "ProductId"),
//            inverseJoinColumns = @JoinColumn(roleName = "ProductPropertyId"))
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(roleName = "PRODUCT_HAS_PROPERTY",
//            joinColumns = @JoinColumn(roleName = "PRODUCT_ID"),
//            inverseJoinColumns = @JoinColumn(roleName = "PROPERTY_ID"))
   // private Set<ProductPropertyEntity> properties = new HashSet<ProductPropertyEntity>();

}
