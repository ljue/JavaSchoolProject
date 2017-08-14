package com.jvschool.dao;

import com.jvschool.entities.PropertyEntity;

import java.util.List;


public interface PropertyDAO {

    List<PropertyEntity> getAllProperties();
    PropertyEntity getPropertyByName(String name);
    PropertyEntity getPropertyById(int id);
}
