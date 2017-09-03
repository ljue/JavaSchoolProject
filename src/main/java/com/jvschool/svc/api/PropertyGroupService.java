package com.jvschool.svc.api;

import com.jvschool.model.PropertyGroupEntity;

import java.util.List;


public interface PropertyGroupService {

    /**
     * Get list of property groups model
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
