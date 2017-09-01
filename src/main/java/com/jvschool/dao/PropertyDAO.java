package com.jvschool.dao;

import com.jvschool.entities.PropertyEntity;
import com.jvschool.entities.PropertyGroupEntity;

import java.util.List;


public interface PropertyDAO {

    List<PropertyEntity> getAllProperties();
    List<PropertyEntity> getPropertiesFromGroup(PropertyGroupEntity group);
    PropertyEntity getPropertyByName(String name);
    PropertyEntity getPropertyById(int id);
    List<PropertyEntity> getSoloProperties();
}
