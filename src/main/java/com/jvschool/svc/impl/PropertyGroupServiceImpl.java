package com.jvschool.svc.impl;

import com.jvschool.dao.impl.PropertyGroupDAOImpl;
import com.jvschool.dto.EditForm;
import com.jvschool.model.PropertyGroupEntity;
import com.jvschool.svc.api.PropertyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PropertyGroupServiceImpl implements PropertyGroupService {

    @Autowired
    private PropertyGroupDAOImpl propertyGroupDAO;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<PropertyGroupEntity> getAllPropertyGroups() {
        return propertyGroupDAO.getAllPropertyGroups();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getNamesAllPropertyGroups() {
        List<String> propertyGroupNames = new ArrayList<>();
        propertyGroupDAO.getAllPropertyGroups().stream()
                .forEachOrdered(propertyGroup -> propertyGroupNames.add(propertyGroup.getPropertyGroupName()));
        return propertyGroupNames;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public PropertyGroupEntity getPropertyGroupById(int id) {
        return propertyGroupDAO.getPropertyGroupById(id);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public PropertyGroupEntity getPropertyGroupByName(String name) {
        return propertyGroupDAO.getPropertyGroupByName(name);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void addPropertyGroup(EditForm editForm) {
        PropertyGroupEntity propertyGroupEntity = new PropertyGroupEntity();
        propertyGroupEntity.setPropertyGroupName(editForm.getAdd());
        boolean t = (editForm.getType().equals("true")) ? true : false;
        propertyGroupEntity.setSolo(t);
        propertyGroupEntity.setVisible(true);
        propertyGroupDAO.addPropertyGroup(propertyGroupEntity);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void editPropertyGroup(EditForm editForm) {
        PropertyGroupEntity groupEntity = propertyGroupDAO.getPropertyGroupByName(editForm.getCurrent());
        groupEntity.setPropertyGroupName(editForm.getEdit());
        propertyGroupDAO.editPropertyGroup(groupEntity);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void removePropertyGroup(String name) {
        propertyGroupDAO.removePropertyGroup(name);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getRemovedPropertyGroups() {
        List<String> propertyGroupNames = new ArrayList<>();
        propertyGroupDAO.getRemovedPropertyGroups().stream()
                .forEachOrdered(propertyGroup -> propertyGroupNames.add(propertyGroup.getPropertyGroupName()));
        return propertyGroupNames;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void returnPropertyGroup(String name) {
        propertyGroupDAO.returnPropertyGroup(name);
    }
}
