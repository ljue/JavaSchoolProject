package com.jvschool.util.Attributes;

import com.jvschool.entities.ProductCategoryEntity;


public class FormEditCategories {
        private ProductCategoryEntity chooseCategory = new ProductCategoryEntity();

    private String editCategory;

    public ProductCategoryEntity getChooseCategory() {
        return chooseCategory;
    }

    public String getEditCategory() {
        return editCategory;
    }

    public void setChooseCategory(ProductCategoryEntity chooseCategory) {
        this.chooseCategory = chooseCategory;
    }

    public void setEditCategory(String editCategory) {
        this.editCategory = editCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormEditCategories)) return false;

        FormEditCategories that = (FormEditCategories) o;

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
