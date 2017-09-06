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
@Table(name = "PICTURE", schema = "MYSHOP_SCHEMA")
public class PicturesEntity implements Serializable {

    @Id
    @Column(name = "PICTURE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pictureId;

    @Basic
    @Column(name = "NAME")
    private String picName;

    @Basic
    @Column(name = "PRODUCT_ID")
    private long productId;

}