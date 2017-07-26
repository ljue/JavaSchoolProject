package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Людмила on 22.07.2017.
 */
@Entity
@Table(name = "PropertyCategory", schema = "myshop_schema")
public class PropertyCategoryEntity  implements Serializable {
    private int propCatId;
    private String propCatName;

    @Id
    @Column(name = "PropCatId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPropCatId() {
        return propCatId;
    }

    public void setPropCatId(int propCatId) {
        this.propCatId = propCatId;
    }

    @Basic
    @Column(name = "PropCatName", nullable = true, length = 255)
    public String getPropCatName() {
        return propCatName;
    }

    public void setPropCatName(String propCatName) {
        this.propCatName = propCatName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyCategoryEntity that = (PropertyCategoryEntity) o;

        if (propCatId != that.propCatId) return false;
        if (propCatName != null ? !propCatName.equals(that.propCatName) : that.propCatName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = propCatId;
        result = 31 * result + (propCatName != null ? propCatName.hashCode() : 0);
        return result;
    }

}
