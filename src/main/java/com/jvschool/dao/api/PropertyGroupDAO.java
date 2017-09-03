package com.jvschool.dao.api;

import com.jvschool.model.PropertyGroupEntity;

import java.util.List;


public interface PropertyGroupDAO {
    List<PropertyGroupEntity> getAllPropertyGroups();
    PropertyGroupEntity getPropertyGroupById(int id);
}
