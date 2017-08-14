package com.jvschool.svc;

import com.jvschool.entities.PropertyGroupEntity;

import java.util.List;


public interface PropertyGroupService {
    List<PropertyGroupEntity> getAllPropertyGroups();
    PropertyGroupEntity getPropertyGroupById(int id);
}
