package com.jvschool.svc.Impl;

import com.jvschool.dao.api.PropertyDAO;
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

    @Override
    public List<PropertyEntity> getAllProperties() {
        return propertyDAO.getAllProperties();
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


}
