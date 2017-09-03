package com.jvschool.svc.Impl;

import com.jvschool.dao.Impl.PropertyGroupDAOImpl;
import com.jvschool.model.PropertyGroupEntity;
import com.jvschool.svc.api.PropertyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class PropertyGroupServiceImpl implements PropertyGroupService {

    @Autowired
    private PropertyGroupDAOImpl propertyCategoryDAO;

    @Override
    public List<PropertyGroupEntity> getAllPropertyGroups() {
        return propertyCategoryDAO.getAllPropertyGroups();
    }

    @Override
    public PropertyGroupEntity getPropertyGroupById(int id) {
        return propertyCategoryDAO.getPropertyGroupById(id);
    }
}
