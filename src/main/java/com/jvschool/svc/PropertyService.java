package com.jvschool.svc;

import com.jvschool.entities.PropertyEntity;

import java.util.List;
import java.util.Map;


public interface PropertyService {
    List<PropertyEntity> getAllProperties();
    PropertyEntity getPropertyByName(String name);
    PropertyEntity getPropertyById(int id);

    Map<String, List<String>> getSoloProperties();
    Map<String, List<String>> getNotSoloProperties();
    Map<String, List<String>> getProperties();
}
