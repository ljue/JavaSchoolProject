package com.jvschool.util.Attributes;


public class CategoryAttribute {


    private String categoryName;
    private String editCategoryName;



    public String getCategoryName() {
        return categoryName;
    }

    public String getEditCategoryName() {
        return editCategoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setEditCategoryName(String editCategoryName) {
        this.editCategoryName = editCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryAttribute)) return false;

        CategoryAttribute that = (CategoryAttribute) o;

        if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null)
            return false;
        return editCategoryName != null ? editCategoryName.equals(that.editCategoryName) : that.editCategoryName == null;
    }

    @Override
    public int hashCode() {
        int result = categoryName != null ? categoryName.hashCode() : 0;
        result = 31 * result + (editCategoryName != null ? editCategoryName.hashCode() : 0);
        return result;
    }
}
