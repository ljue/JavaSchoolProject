package com.jvschool.svc.Impl;

import com.jvschool.dao.PropertyRadioCategoryDAO;
import com.jvschool.entities.PropertyRadioCategoryEntity;
import com.jvschool.svc.PropertyRadioCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Service
@Transactional
public class PropertyRadioCategoryServiceImpl implements PropertyRadioCategoryService {

    @Autowired
    private PropertyRadioCategoryDAO propertyRadioCategoryDAO;

    @Override
    public List<PropertyRadioCategoryEntity> getAllRadioCategories() {
        return propertyRadioCategoryDAO.getAllRadioCategories();
    }
}
