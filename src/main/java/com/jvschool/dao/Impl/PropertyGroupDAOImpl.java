package com.jvschool.dao.Impl;

import com.jvschool.dao.api.PropertyGroupDAO;
import com.jvschool.model.PropertyGroupEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Log4j
@Repository
public class PropertyGroupDAOImpl implements PropertyGroupDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PropertyGroupEntity> getAllPropertyGroups() {

        List <PropertyGroupEntity> properties = em.createQuery("FROM PropertyGroupEntity ").getResultList();

        return properties;
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
//        List list = em.createQuery("FROM PropertyGroupEntity " +
//                "where propCatId=:id").setParameter("id", id).getResultList();
//
//        if(list.isEmpty())
//            return null;
//        else
//            return (PropertyGroupEntity) list.get(0);
    }
}
