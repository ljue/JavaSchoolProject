package com.jvschool.entities;

import javax.persistence.*;

/**
 * Created by Людмила on 22.07.2017.
 */
@Entity
@Table(name = "Pictures", schema = "myshop_schema")
public class PicturesEntity {
    private long pictureId;
    private String picName;
    private Long productId;
    //private ProductEntity productByProductId;

    @Id
    @Column(name = "PictureId", nullable = false)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getPictureId() {
        return pictureId;
    }

    public void setPictureId(long pictureId) {
        this.pictureId = pictureId;
    }

    @Basic
    @Column(name = "PicName", nullable = true, length = 255)
    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    @Basic
    @Column(name = "ProductId", nullable = true)
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PicturesEntity that = (PicturesEntity) o;

        if (pictureId != that.pictureId) return false;
        if (picName != null ? !picName.equals(that.picName) : that.picName != null) return false;
      //  if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (pictureId ^ (pictureId >>> 32));
        result = 31 * result + (picName != null ? picName.hashCode() : 0);
      //  result = 31 * result + (productId != null ? productId.hashCode() : 0);
        return result;
    }

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
//    public ProductEntity getProductByProductId() {
//        return productByProductId;
//    }
//
//    public void setProductByProductId(ProductEntity productByProductId) {
//        this.productByProductId = productByProductId;
//    }
}
