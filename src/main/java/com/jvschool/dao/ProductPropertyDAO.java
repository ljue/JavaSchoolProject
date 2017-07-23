package com.jvschool.dao;

import com.jvschool.entities.ProductPropertyEntity;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface ProductPropertyDAO {

    List<ProductPropertyEntity> getAllProductProperties();
    ProductPropertyEntity getProductPropertyByName(String name);
    ProductPropertyEntity getProductPropertyById(int id);
}
