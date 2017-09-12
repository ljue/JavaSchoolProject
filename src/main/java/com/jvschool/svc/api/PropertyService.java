package com.jvschool.svc.api;

import com.jvschool.dto.EditForm;
import com.jvschool.model.PropertyEntity;

import java.util.List;
import java.util.Map;


public interface PropertyService {

    /**
     * Gets list of all visible properties {@link PropertyEntity} and returns list of their names.
     * @return
     */
    List<String> getAllVisibleProperties();

    /**
     * Gets property {@link PropertyEntity} by name
     * @param name
     * @return
     */
    PropertyEntity getPropertyByName(String name);

    /**
     * Get property {@link PropertyEntity} by id
     * @param id
     * @return
     */
    PropertyEntity getPropertyById(int id);

    /**
     * Gets properties {@link PropertyEntity},
     * among which product {@link com.jvschool.model.ProductEntity} can has only one value
     * in group {@link com.jvschool.model.PropertyGroupEntity},
     * and breaks them up into groups
     * @return map: key - name group of properties, value - list properties names into group
     */
    Map<String, List<String>> getSoloProperties();

    /**
     * Gets properties {@link PropertyEntity},
     * among which product {@link com.jvschool.model.ProductEntity}  can has several values
     * in group {@link com.jvschool.model.PropertyGroupEntity},
     * and breaks them up into groups
     * @return map: key - name group of properties, value - list properties names into group
     */
    Map<String, List<String>> getNotSoloProperties();

    /**
     * Gets all properties {@link PropertyEntity} and break up into groups
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
