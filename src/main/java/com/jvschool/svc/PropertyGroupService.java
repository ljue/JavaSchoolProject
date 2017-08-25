package com.jvschool.svc;

import com.jvschool.entities.PropertyGroupEntity;

import java.util.List;


public interface PropertyGroupService {

    /**
     * Get list of property groups entities
     * @return
     */
    List<PropertyGroupEntity> getAllPropertyGroups();

    /**
     * Get property group entity by id
     * @param id
     * @return
     */
    PropertyGroupEntity getPropertyGroupById(int id);
}
