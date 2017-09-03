package com.jvschool.svc.api;

import com.jvschool.model.PropertyEntity;

import java.util.List;
import java.util.Map;


public interface PropertyService {

    /**
     * Get list of all property model
     * @return
     */
    List<PropertyEntity> getAllProperties();

    /**
     * Get property entity by name
     * @param name
     * @return
     */
    PropertyEntity getPropertyByName(String name);

    /**
     * Get property entity by id
     * @param id
     * @return
     */
    PropertyEntity getPropertyById(int id);

    /**
     * Get properties, among which product can has only one value in group, and break them up into groups
     * @return map: key - name group of properties, value - list properties names into group
     */
    Map<String, List<String>> getSoloProperties();

    /**
     * Get properties, among which product can has several values in group, and break them up into groups
     * @return map: key - name group of properties, value - list properties names into group
     */
    Map<String, List<String>> getNotSoloProperties();

    /**
     * Get all properties and break up into groups
     * @return map: key - name group of properties, value - list properties names into group
     */
    Map<String, List<String>> getProperties();
}
