package com.jvschool.dao;

import com.jvschool.entities.PropertyGroupEntity;

import java.util.List;


public interface PropertyGroupDAO {
    List<PropertyGroupEntity> getAllPropertyGroups();
    PropertyGroupEntity getPropertyGroupById(int id);
}
