package com.jvschool.svc.impl;


import com.jvschool.dao.api.CategoryDAO;
import com.jvschool.model.CategoryEntity;
import com.jvschool.svc.api.CategoryService;
import com.jvschool.dto.CategoryAttribute;
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
        List<String> categoryNames = new ArrayList<>();
        categoryDAO.getAllProductCategories().stream()
                .forEachOrdered(categoryEntity -> categoryNames.add(categoryEntity.getCategoryName()));
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
        CategoryEntity categoryEntity = categoryDAO.getProductCategoryByName(categoryAttribute.getCategoryName());
        if(categoryEntity==null) {
            categoryEntity = new CategoryEntity();
        }
        categoryEntity.setCategoryName(categoryAttribute.getEditCategoryName());
        categoryDAO.editCategory(categoryEntity);
    }

    @Override
    public void removeCategory(String category) {
        categoryDAO.removeCategory(categoryDAO.getProductCategoryByName(category));
    }

    @Override
    public List<String> getRemovedCategories() {
        List<String> categoryNames = new ArrayList<>();
        categoryDAO.getRemovedCategories().stream()
                .forEachOrdered(categoryEntity -> categoryNames.add(categoryEntity.getCategoryName()));
        return categoryNames;
    }

    @Override
    public void returnCategory(String category) {
        categoryDAO.returnCategory(categoryDAO.getProductCategoryByName(category));
    }

}
