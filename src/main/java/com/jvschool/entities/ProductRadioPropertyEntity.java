package com.jvschool.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Entity
@Table(name = "ProductRadioProperty", schema = "MYSHOP_SCHEMA", catalog = "")
public class ProductRadioPropertyEntity {
    private int id;
    private String name;
    private PropertyRadioCategoryEntity propertyRadioCategoryByRadioCategoryId;
    private List<ProductEntity> productEntities;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductRadioPropertyEntity that = (ProductRadioPropertyEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "radioCategoryId", referencedColumnName = "id")
    public PropertyRadioCategoryEntity getPropertyRadioCategoryByRadioCategoryId() {
        return propertyRadioCategoryByRadioCategoryId;
    }

    public void setPropertyRadioCategoryByRadioCategoryId(PropertyRadioCategoryEntity propertyRadioCategoryByRadioCategoryId) {
        this.propertyRadioCategoryByRadioCategoryId = propertyRadioCategoryByRadioCategoryId;
    }

    @ManyToMany
    @JoinTable(name = "Prod_RadioProp",
            joinColumns = @JoinColumn(name = "RadioPropId"),
            inverseJoinColumns = @JoinColumn(name = "ProductId"))
    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setProductEntities(List<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }
}
