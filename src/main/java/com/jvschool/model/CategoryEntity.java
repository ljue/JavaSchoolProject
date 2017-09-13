package com.jvschool.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


@ToString
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

    @Basic
    @Column(name = "VISIBLE")
    private boolean visible;

}
