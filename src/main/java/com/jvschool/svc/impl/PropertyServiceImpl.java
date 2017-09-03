package com.jvschool.svc.impl;

import com.jvschool.dao.api.PropertyDAO;
import com.jvschool.dao.api.PropertyGroupDAO;
import com.jvschool.dto.EditForm;
import com.jvschool.model.PropertyEntity;
import com.jvschool.svc.api.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyDAO propertyDAO;
    @Autowired
    private PropertyGroupDAO propertyGroupDAO;

    @Override
    public List<String> getAllVisibleProperties() {
        List<String> propertyNames = new ArrayList<>();
        for(PropertyEntity property : propertyDAO.getAllProperties()) {
            if(property.getPropertyGroup().isVisible() && property.isVisible()) {
                propertyNames.add(property.getPropertyName());
            }
        }
        return propertyNames;
    }

    @Override
    public PropertyEntity getPropertyByName(String name) {
        return propertyDAO.getPropertyByName(name);
    }

    @Override
    public PropertyEntity getPropertyById(int id) {
        return propertyDAO.getPropertyById(id);
    }

    @Override
    public Map<String, List<String>> getSoloProperties() {
        Map<String, List<String>> properties = new HashMap<>();

        for (PropertyEntity propertyEntity : propertyDAO.getAllProperties()) {
            if(propertyEntity.getPropertyGroup().isSolo()) {
                properties.computeIfAbsent(propertyEntity.getPropertyGroup().getPropertyGroupName(),
                        v -> new ArrayList<>()).add(propertyEntity.getPropertyName());
            }
        }
        return properties;
    }

    @Override
    public Map<String, List<String>> getNotSoloProperties() {
        Map<String, List<String>> properties = new HashMap<>();

        for (PropertyEntity propertyEntity : propertyDAO.getAllProperties()) {
            if(!propertyEntity.getPropertyGroup().isSolo()) {
                properties.computeIfAbsent(propertyEntity.getPropertyGroup().getPropertyGroupName(),
                        v -> new ArrayList<>()).add(propertyEntity.getPropertyName());
            }
        }
        return properties;
    }

    @Override
    public Map<String, List<String>> getProperties() {
        Map<String, List<String>> properties = new HashMap<>();

        for (PropertyEntity propertyEntity : propertyDAO.getAllProperties()) {
            properties.computeIfAbsent(propertyEntity.getPropertyGroup().getPropertyGroupName(),
                    v -> new ArrayList<>()).add(propertyEntity.getPropertyName());
        }
        return properties;
    }

    @Override
    public void addProperty(EditForm form) {
        PropertyEntity property = new PropertyEntity();
        property.setVisible(true);
        property.setPropertyName(form.getAdd());
        property.setPropertyGroup(propertyGroupDAO.getPropertyGroupByName(form.getType()));
        propertyDAO.addProperty(property);
    }

    @Override
    public void editProperty(EditForm editForm) {
        PropertyEntity property = propertyDAO.getPropertyByName(editForm.getCurrent());
        property.setPropertyName(editForm.getEdit());
        propertyDAO.editProperty(property);
    }

    @Override
    public void removeProperty(String name) {
        propertyDAO.removeProperty(name);
    }

    @Override
    public List<String> getRemovedProperties() {
        List<String> propertyNames = new ArrayList<>();
        propertyDAO.getRemovedPropertiesVisibleGroups().stream()
                .forEachOrdered(property -> propertyNames.add(property.getPropertyName()));
        return propertyNames;
    }

    @Override
    public void returnProperty(String name) {
        propertyDAO.returnProperty(name);
    }


}
