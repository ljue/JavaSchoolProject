package com.jvschool.svc.Impl;


import com.jvschool.dao.CategoryDAO;
import com.jvschool.entities.CategoryEntity;
import com.jvschool.svc.CategoryService;
import com.jvschool.util.Attributes.CategoryAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;


    @Override
    public List<String> getAllProductCategoryNames() {
        List<CategoryEntity> lce = categoryDAO.getAllProductCategories();
        List<String> categoryNames = new ArrayList<>();
        if (!lce.isEmpty()) {
            for(CategoryEntity ce : lce) {
                categoryNames.add(ce.getCategoryName());
            }
        }
        return categoryNames;
    }

    @Override
    public CategoryEntity getProductCategoryByName(String name) {
        return categoryDAO.getProductCategoryByName(name);
    }

    @Override
    public void addProductCategory(String name) {
        categoryDAO.addProductCategory(name);
    }

    @Override
    public void editCategory(CategoryAttribute categoryAttribute) {
        CategoryEntity pce = categoryDAO.getProductCategoryByName(categoryAttribute.getCategoryName());
        if(pce==null) {
            pce = new CategoryEntity();
        }
        pce.setCategoryName(categoryAttribute.getEditCategoryName());
        categoryDAO.editCategory(pce);
    }

}
