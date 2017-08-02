package com.jvschool.dao.Impl;

import com.jvschool.dao.PropertyRadioCategoryDAO;
import com.jvschool.entities.PropertyRadioCategoryEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class PropertyRadioCategoryDAOImpl implements PropertyRadioCategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PropertyRadioCategoryEntity> getAllRadioCategories() {

        List <PropertyRadioCategoryEntity> properties = em.createQuery("FROM PropertyRadioCategoryEntity ").getResultList();
        return properties;
    }
}
