package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by Людмила on 22.07.2017.
 */
@Entity
@Table(name = "ProductProperty", schema = "myshop_schema")
public class ProductPropertyEntity  implements Serializable {
    private int prodPropId;
    //private Integer prodPropCatId;
    private String prodPropName;
    private PropertyCategoryEntity propertyCategoryByProdPropCatId;
    private List<ProductEntity> product;

    @Id
    @Column(name = "ProdPropId", nullable = false)
    public int getProdPropId() {
        return prodPropId;
    }

    public void setProdPropId(int prodPropId) {
        this.prodPropId = prodPropId;
    }

//    @Basic
//    @Column(name = "ProdPropCatId", nullable = true)
//    public Integer getProdPropCatId() {
//        return prodPropCatId;
//    }
//
//    public void setProdPropCatId(Integer prodPropCatId) {
//        this.prodPropCatId = prodPropCatId;
//    }

    @Basic
    @Column(name = "ProdPropName", nullable = true, length = 255)
    public String getProdPropName() {
        return prodPropName;
    }

    public void setProdPropName(String prodPropName) {
        this.prodPropName = prodPropName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductPropertyEntity that = (ProductPropertyEntity) o;

        if (prodPropId != that.prodPropId) return false;
        //if (prodPropCatId != null ? !prodPropCatId.equals(that.prodPropCatId) : that.prodPropCatId != null)
        //    return false;
        if (prodPropName != null ? !prodPropName.equals(that.prodPropName) : that.prodPropName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodPropId;
       // result = 31 * result + (prodPropCatId != null ? prodPropCatId.hashCode() : 0);
        result = 31 * result + (prodPropName != null ? prodPropName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ProdPropCatId", referencedColumnName = "PropCatId")
    public PropertyCategoryEntity getPropertyCategoryByProdPropCatId() {
        return propertyCategoryByProdPropCatId;
    }

    public void setPropertyCategoryByProdPropCatId(PropertyCategoryEntity propertyCategoryByProdPropCatId) {
        this.propertyCategoryByProdPropCatId = propertyCategoryByProdPropCatId;
    }



    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable(name = "Prod_Prop",
            joinColumns = @JoinColumn(name = "ProductPropertyId"),
            inverseJoinColumns = @JoinColumn(name = "ProductId"))
    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }
}
