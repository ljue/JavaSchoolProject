package com.jvschool.dao.impl;

import com.jvschool.dao.api.PropertyGroupDAO;
import com.jvschool.model.PropertyGroupEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Log4j
@Repository
public class PropertyGroupDAOImpl implements PropertyGroupDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PropertyGroupEntity> getAllPropertyGroups() {

        return em.createQuery("FROM PropertyGroupEntity  where visible=:visible ")
                .setParameter("visible", true).getResultList();
    }

    @Override
    public PropertyGroupEntity getPropertyGroupById(int id) {

        PropertyGroupEntity propertyGroupEntity = null;

        try {
            propertyGroupEntity = em.find(PropertyGroupEntity.class, id);
        } catch (Exception e) {
            log.error(e.toString());
        }

        return propertyGroupEntity;
    }

    @Override
    public PropertyGroupEntity getPropertyGroupByName(String name) {
        List list = em.createQuery("FROM PropertyGroupEntity " +
                "where propertyGroupName=:name").setParameter("name", name).getResultList();

        return (list.isEmpty()) ? null : (PropertyGroupEntity) list.get(0);
    }

    @Override
    public void addPropertyGroup(PropertyGroupEntity propertyGroupEntity) {
        em.persist(propertyGroupEntity);
        log.info("Add property group: " + propertyGroupEntity);
    }

    @Override
    public void editPropertyGroup(PropertyGroupEntity propertyGroup) {
        em.merge(propertyGroup);
    }

    @Override
    public void removePropertyGroup(String name) {
        Query query = em.createQuery("UPDATE PropertyGroupEntity set visible=:visible where propertyGroupName=:propertyGroupName")
                .setParameter("propertyGroupName", name).setParameter("visible", false);

        query.executeUpdate();
        log.info("Remove property group: " + name);
    }

    @Override
    public List<PropertyGroupEntity> getRemovedPropertyGroups() {

        return em.createQuery("FROM PropertyGroupEntity where visible=:visible ")
                .setParameter("visible", false).getResultList();
    }

    @Override
    public void returnPropertyGroup(String name) {
        Query query = em.createQuery("UPDATE PropertyGroupEntity set visible=:visible where propertyGroupName=:propertyGroupName")
                .setParameter("propertyGroupName", name).setParameter("visible", true);

        query.executeUpdate();
        log.info("Return property group: " + name);
    }
}
