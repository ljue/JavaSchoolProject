package com.jvschool.svc.api;


import com.jvschool.dto.EditForm;
import com.jvschool.model.PropertyGroupEntity;

import java.util.List;


public interface PropertyGroupService {

    /**
     * Get list of property groups model
     * @return
     */
    List<PropertyGroupEntity> getAllPropertyGroups();

    /**
     * Get list of names of property groups model
     * @return
     */
    List<String> getNamesAllPropertyGroups();

    /**
     * Get property group entity by id
     * @param id
     * @return
     */
    PropertyGroupEntity getPropertyGroupById(int id);

    /**
     * Gets {@link PropertyGroupEntity} from database by name.
     * @param name String
     * @return {@link PropertyGroupEntity} with the specified {@link PropertyGroupEntity#propertyGroupName} or null.
     */
    PropertyGroupEntity getPropertyGroupByName(String name);

    /**
     * Create new {@link PropertyGroupEntity} and sets new name, solo type, true visible.
     * Saves it in database.
     * @param form
     */
    void addPropertyGroup(EditForm form);

    /**
     * Gets {@link PropertyGroupEntity} by {@link PropertyGroupEntity#propertyGroupName}
     * and sets new name.
     * @param editForm
     */
    void editPropertyGroup(EditForm editForm);

    /**
     * Sets {@link PropertyGroupEntity#visible} false to {@link PropertyGroupEntity}
     * by {@link PropertyGroupEntity#propertyGroupName}
     * @param name
     */
    void removePropertyGroup(String name);

    /**
     * Gets list of {@link PropertyGroupEntity} where {@link PropertyGroupEntity#visible}
     * is false. And transform it to list of String names.
     * @return
     */
    List<String> getRemovedPropertyGroups();

    /**
     * Sets {@link PropertyGroupEntity#visible} true to {@link PropertyGroupEntity}
     * by {@link PropertyGroupEntity#propertyGroupName}
     * @param name
     */
    void returnPropertyGroup(String name);
}
