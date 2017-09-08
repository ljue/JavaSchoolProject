package com.jvschool.dao.impl;

import com.jvschool.dao.api.PropertyDAO;
import com.jvschool.model.PropertyEntity;
import com.jvschool.model.PropertyGroupEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class PropertyDAOImpl implements PropertyDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PropertyEntity> getAllProperties() {

        return em.createQuery("FROM PropertyEntity where visible=:visible and propertyGroup.visible=:groupVisible ")
                .setParameter("visible", true).setParameter("groupVisible", true).getResultList();
    }

    @Override
    public List<PropertyEntity> getPropertiesFromGroup(PropertyGroupEntity group) {
        return  em.createQuery("FROM PropertyEntity " +
                " where propertyGroup=:propertyGroup").setParameter("propertyGroup", group).getResultList();
    }

    @Override
    public PropertyEntity getPropertyByName(String name) {
        List list = em.createQuery("FROM PropertyEntity " +
                "where propertyName=:name").setParameter("name", name).getResultList();

        return (list.isEmpty()) ? null : (PropertyEntity) list.get(0);
    }

    @Override
    public PropertyEntity getPropertyById(int id) {
        List list = em.createQuery("FROM PropertyEntity " +
                "where propertyId=:id").setParameter("id", id).getResultList();

        return (list.isEmpty()) ? null : (PropertyEntity) list.get(0);
    }

    @Override
    public List<PropertyEntity> getSoloProperties() {
        return  em.createQuery("FROM PropertyEntity " +
                " where propertyGroup.solo=:solo").setParameter("solo", true).getResultList();
    }

    @Override
    public void addProperty(PropertyEntity property) {
        em.persist(property);
    }

    @Override
    public void editProperty(PropertyEntity property) {
        em.merge(property);
    }

    @Override
    public void removeProperty(String name) {
        Query query = em.createQuery("UPDATE PropertyEntity set visible=:visible where propertyName=:propertyName")
                .setParameter("propertyName", name).setParameter("visible", false);

        query.executeUpdate();
    }

    @Override
    public List<PropertyEntity> getRemovedPropertiesVisibleGroups() {

        return em.createQuery("FROM PropertyEntity where visible=:visible " +
                "and propertyGroup.visible=:groupVisible")
                .setParameter("visible", false).setParameter("groupVisible", true).getResultList();
    }

    @Override
    public void returnProperty(String name) {

        Query query = em.createQuery("UPDATE PropertyEntity set visible=:visible where propertyName=:propertyName")
                .setParameter("propertyName", name).setParameter("visible", true);

        query.executeUpdate();
    }
}
