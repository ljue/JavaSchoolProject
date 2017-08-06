package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "PROPERTY", schema = "MYSHOP_SCHEMA")
public class ProductPropertyEntity  implements Serializable {
    private int prodPropId;
    private String prodPropName;
    private PropertyCategoryEntity propertyCategoryByProdPropCatId;

    @Id
    @Column(name = "PROPERTY_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getProdPropId() {
        return prodPropId;
    }

    public void setProdPropId(int prodPropId) {
        this.prodPropId = prodPropId;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 255)
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
        if (prodPropName != null ? !prodPropName.equals(that.prodPropName) : that.prodPropName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodPropId;
        result = 31 * result + (prodPropName != null ? prodPropName.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PROPERTY_GROUP_ID")
    public PropertyCategoryEntity getPropertyCategoryByProdPropCatId() {
        return propertyCategoryByProdPropCatId;
    }

    public void setPropertyCategoryByProdPropCatId(PropertyCategoryEntity propertyCategoryByProdPropCatId) {
        this.propertyCategoryByProdPropCatId = propertyCategoryByProdPropCatId;
    }


}
