package com.jvschool.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "CATEGORY", schema = "MYSHOP_SCHEMA")
public class CategoryEntity implements Serializable {

    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Basic
    @Column(name = "NAME")
    private String categoryName;

}