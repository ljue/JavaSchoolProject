package com.jvschool.dao.Impl;

import com.jvschool.dao.PropertyCategoryDAO;
import com.jvschool.entities.PropertyCategoryEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Repository
public class PropertyCategoryDAOImpl implements PropertyCategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PropertyCategoryEntity> getAllProductCategories() {

        List <PropertyCategoryEntity> properties = em.createQuery("FROM PropertyCategoryEntity ").getResultList();

        return properties;
    }

    @Override
    public PropertyCategoryEntity getProductCategoryById(int id) {

        List list = em.createQuery("FROM PropertyCategoryEntity " +
                "where propCatId=:id").setParameter("id", id).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (PropertyCategoryEntity) list.get(0);
    }
}
