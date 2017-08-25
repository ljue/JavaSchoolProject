package com.jvschool.dao.Impl;

import com.jvschool.dao.PropertyDAO;
import com.jvschool.entities.PropertyEntity;
import com.jvschool.entities.PropertyGroupEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class PropertyDAOImpl implements PropertyDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PropertyEntity> getAllProperties() {

        List <PropertyEntity> properties = em.createQuery("FROM PropertyEntity ").getResultList();

        return properties;
    }

    @Override
    public List<PropertyEntity> getPropertiesFromGroup(PropertyGroupEntity group) {

        List<PropertyEntity> propertyEntityList = em.createQuery("FROM PropertyEntity " +
                " where propertyGroup=:propertyGroup").setParameter("propertyGroup", group).getResultList();
        return  propertyEntityList;
    }

    @Override
    public PropertyEntity getPropertyByName(String name) {

        List list = em.createQuery("FROM PropertyEntity " +
                "where propertyName=:name").setParameter("name", name).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (PropertyEntity) list.get(0);
    }

    @Override
    public PropertyEntity getPropertyById(int id) {

        List list = em.createQuery("FROM PropertyEntity " +
                "where propertyId=:id").setParameter("id", id).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (PropertyEntity) list.get(0);
    }
}
