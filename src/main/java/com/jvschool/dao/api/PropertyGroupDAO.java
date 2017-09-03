package com.jvschool.dao.api;

import com.jvschool.model.PropertyGroupEntity;

import java.util.List;


public interface PropertyGroupDAO {
    List<PropertyGroupEntity> getAllPropertyGroups();
    PropertyGroupEntity getPropertyGroupById(int id);
    PropertyGroupEntity getPropertyGroupByName(String name);
    void addPropertyGroup(PropertyGroupEntity propertyGroupEntity);
    void editPropertyGroup(PropertyGroupEntity propertyGroup);
    void removePropertyGroup(String name);
    List<PropertyGroupEntity> getRemovedPropertyGroups();
    void returnPropertyGroup(String name);
}
