package com.jvschool.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CategoryAttribute {

    private String categoryName;
    private String editCategoryName;
    private String addCategoryName;
    private String removeCategoryName;
    private String returnCategoryName;

}
