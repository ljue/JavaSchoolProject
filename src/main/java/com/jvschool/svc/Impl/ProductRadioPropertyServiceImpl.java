package com.jvschool.svc.Impl;

import com.jvschool.dao.api.ProductRadioPropertyDAO;
import com.jvschool.entities.ProductRadioPropertyEntity;
import com.jvschool.svc.api.ProductRadioPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Service
@Transactional
public class ProductRadioPropertyServiceImpl implements ProductRadioPropertyService {

    @Autowired
    private ProductRadioPropertyDAO productRadioPropertyDAO;

    @Override
    public List<ProductRadioPropertyEntity> getAllRadioProperties() {
        return productRadioPropertyDAO.getAllRadioProperties();
    }

    @Override
    public ProductRadioPropertyEntity getProductRadioPropertyByName(String name) {
        return productRadioPropertyDAO.getProductRadioPropertyByName(name);
    }

    @Override
    public ProductRadioPropertyEntity getProductRadioPropertyById(int id) {
        return productRadioPropertyDAO.getProductRadioPropertyById(id);
    }
}
