package com.jvschool.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Людмила on 23.07.2017.
 */
@Entity
@Table(name = "PropertyRadioCategory", schema = "myshop_schema", catalog = "")
public class PropertyRadioCategoryEntity {
    private int id;
    private String name;
    private Collection<ProductRadioPropertyEntity> productRadioPropertiesById;

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

        PropertyRadioCategoryEntity that = (PropertyRadioCategoryEntity) o;

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

    @OneToMany(mappedBy = "propertyRadioCategoryByRadioCategoryId")
    public Collection<ProductRadioPropertyEntity> getProductRadioPropertiesById() {
        return productRadioPropertiesById;
    }

    public void setProductRadioPropertiesById(Collection<ProductRadioPropertyEntity> productRadioPropertiesById) {
        this.productRadioPropertiesById = productRadioPropertiesById;
    }
}
