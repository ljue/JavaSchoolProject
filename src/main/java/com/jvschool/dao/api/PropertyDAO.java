package com.jvschool.dao.api;

import com.jvschool.model.PropertyEntity;
import com.jvschool.model.PropertyGroupEntity;

import java.util.List;


public interface PropertyDAO {

    List<PropertyEntity> getAllProperties();
    List<PropertyEntity> getPropertiesFromGroup(PropertyGroupEntity group);
    PropertyEntity getPropertyByName(String name);
    PropertyEntity getPropertyById(int id);
    List<PropertyEntity> getSoloProperties();

    void addProperty(PropertyEntity property);
    void editProperty(PropertyEntity property);
    void removeProperty(String name);
    List<PropertyEntity> getRemovedPropertiesVisibleGroups();
    void returnProperty(String name);
}
