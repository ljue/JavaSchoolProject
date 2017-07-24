package com.jvschool.util;

import com.jvschool.entities.ProductCategoryEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Basic;
import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
@Component
public class FormListCategories {

//    List<ProductCategoryEntity> productCategoryEntityList;
//
//    public List<ProductCategoryEntity> getProductCategoryEntityList() {
//        return productCategoryEntityList;
//    }
//
//    public void setProductCategoryEntityList(List<ProductCategoryEntity> productCategoryEntityList) {
//        this.productCategoryEntityList = productCategoryEntityList;
//    }



    private ProductCategoryEntity chooseCategory;

    private String editCategory;

    public ProductCategoryEntity getChooseCategory() {
        return chooseCategory;
    }

    public String getEditCategory() {
        return editCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormListCategories)) return false;

        FormListCategories that = (FormListCategories) o;

        if (chooseCategory != null ? !chooseCategory.equals(that.chooseCategory) : that.chooseCategory != null)
            return false;
        return editCategory != null ? editCategory.equals(that.editCategory) : that.editCategory == null;
    }

    @Override
    public int hashCode() {
        int result = chooseCategory != null ? chooseCategory.hashCode() : 0;
        result = 31 * result + (editCategory != null ? editCategory.hashCode() : 0);
        return result;
    }
}