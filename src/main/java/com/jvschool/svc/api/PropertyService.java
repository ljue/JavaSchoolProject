package com.jvschool.svc.api;

import com.jvschool.dto.EditForm;
import com.jvschool.model.PropertyEntity;

import java.util.List;
import java.util.Map;


public interface PropertyService {

    /**
     * Gets list of all visible properties and return list of their names.
     * @return
     */
    List<String> getAllVisibleProperties();

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

    /**
     * Create new {@link PropertyEntity} and sets new name, property group, true visible.
     * Saves it in database.
     * @param form
     */
    void addProperty(EditForm form);

    /**
     * Gets {@link PropertyEntity} by {@link PropertyEntity#propertyName}
     * and sets new name.
     * @param editForm
     */
    void editProperty(EditForm editForm);

    /**
     * Sets {@link PropertyEntity#visible} false to {@link PropertyEntity}
     * by {@link PropertyEntity#propertyName}
     * @param name
     */
    void removeProperty(String name);

    /**
     * Gets list of {@link PropertyEntity} where {@link PropertyEntity#visible}
     * is false but {@link PropertyEntity#propertyGroup#visible} is true. And transform it to list of String names.
     * @return
     */
    List<String> getRemovedProperties();

    /**
     * Sets {@link PropertyEntity#visible} true to {@link PropertyEntity}
     * by {@link PropertyEntity#propertyName}
     * @param name
     */
    void returnProperty(String name);
}
