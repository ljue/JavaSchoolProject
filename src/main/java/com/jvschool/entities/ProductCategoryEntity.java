package com.jvschool.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Людмила on 22.07.2017.
 */
@Entity
@Table(name = "ProductCategory", schema = "myshop_schema")
public class ProductCategoryEntity  implements Serializable {
    private int categoryId;
    private String categoryName;
    private Collection<ProductEntity> productsByCategoryId;

    @Id
    @Column(name = "CategoryId", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "CategoryName", nullable = true, length = 50)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductCategoryEntity that = (ProductCategoryEntity) o;

        if (categoryId != that.categoryId) return false;
        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productCategoryByCategory")
    public Collection<ProductEntity> getProductsByCategoryId() {
        return productsByCategoryId;
    }

    public void setProductsByCategoryId(Collection<ProductEntity> productsByCategoryId) {
        this.productsByCategoryId = productsByCategoryId;
    }
}
