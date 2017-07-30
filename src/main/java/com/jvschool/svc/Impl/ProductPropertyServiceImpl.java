package com.jvschool.svc.Impl;

import com.jvschool.dao.api.ProductPropertyDAO;
import com.jvschool.entities.ProductPropertyEntity;
import com.jvschool.svc.api.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Service
@Transactional
public class ProductPropertyServiceImpl implements ProductPropertyService {

    @Autowired
    private ProductPropertyDAO productPropertyDAO;

    @Override
    public List<ProductPropertyEntity> getAllProductProperties() {
        return productPropertyDAO.getAllProductProperties();
    }

    @Override
    public ProductPropertyEntity getProductPropertyByName(String name) {
        return productPropertyDAO.getProductPropertyByName(name);
    }

    @Override
    public ProductPropertyEntity getProductPropertyById(int id) {
        return productPropertyDAO.getProductPropertyById(id);
    }
}
