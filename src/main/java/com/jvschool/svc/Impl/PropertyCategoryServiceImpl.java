package com.jvschool.svc.Impl;

import com.jvschool.dao.Impl.PropertyCategoryDAOImpl;
import com.jvschool.entities.PropertyCategoryEntity;
import com.jvschool.svc.PropertyCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Service
@Transactional
public class PropertyCategoryServiceImpl implements PropertyCategoryService {

    @Autowired
    private PropertyCategoryDAOImpl propertyCategoryDAO;

    @Override
    public List<PropertyCategoryEntity> getAllPropertyCategories() {
        return propertyCategoryDAO.getAllProductCategories();
    }

    @Override
    public PropertyCategoryEntity getProductCategoryById(int id) {
        return propertyCategoryDAO.getProductCategoryById(id);
    }
}
