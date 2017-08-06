package com.jvschool.dao;

import com.jvschool.entities.ProductPropertyEntity;

import java.util.List;


public interface ProductPropertyDAO {

    List<ProductPropertyEntity> getAllProductProperties();
    ProductPropertyEntity getProductPropertyByName(String name);
    ProductPropertyEntity getProductPropertyById(int id);
}
