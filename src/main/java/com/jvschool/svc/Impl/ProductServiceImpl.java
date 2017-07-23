package com.jvschool.svc.Impl;

import com.jvschool.dao.ProductDAO;
import com.jvschool.entities.ProductEntity;
import com.jvschool.svc.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Людмила on 23.07.2017.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void addProduct(ProductEntity productEntity) {
        productDAO.addProduct(productEntity);
    }
}
