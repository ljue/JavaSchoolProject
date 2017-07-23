package com.jvschool.dao;

import com.jvschool.entities.ProductRadioPropertyEntity;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
public interface ProductRadioPropertyDAO {

    List<ProductRadioPropertyEntity> getAllRadioProperties();
    ProductRadioPropertyEntity getProductRadioPropertyByName(String name);
    ProductRadioPropertyEntity getProductRadioPropertyById(int id);
}
