package com.jvschool.svc;

import com.jvschool.entities.ProductPropertyEntity;

import java.util.List;


public interface ProductPropertyService {
    List<ProductPropertyEntity> getAllProductProperties();
    ProductPropertyEntity getProductPropertyByName(String name);
    ProductPropertyEntity getProductPropertyById(int id);
}
