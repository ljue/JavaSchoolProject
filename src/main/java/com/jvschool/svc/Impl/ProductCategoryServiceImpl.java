package com.jvschool.svc.Impl;

import com.jvschool.dao.Impl.ProductCategoryDAOImpl;
import com.jvschool.entities.ProductCategoryEntity;
import com.jvschool.svc.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDAOImpl productCategoryDAO;

    @Override
    public List<ProductCategoryEntity> getAllProductCategories() {
        return productCategoryDAO.getAllProductCategories();

    }

    @Override
    public ProductCategoryEntity getProductCategoryById(int id) {
        return productCategoryDAO.getProductCategoryById(id);
    }

    @Override
    public ProductCategoryEntity getProductCategoryByName(String name) {
        return productCategoryDAO.getProductCategoryByName(name);
    }
}
