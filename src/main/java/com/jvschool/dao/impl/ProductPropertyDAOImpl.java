package com.jvschool.dao.impl;

import com.jvschool.dao.api.ProductPropertyDAO;
import com.jvschool.entities.ProductPropertyEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Repository
public class ProductPropertyDAOImpl implements ProductPropertyDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductPropertyEntity> getAllProductProperties() {

        List <ProductPropertyEntity> properties = em.createQuery("FROM ProductPropertyEntity ").getResultList();

        return properties;
    }

    @Override
    public ProductPropertyEntity getProductPropertyByName(String name) {

        List list = em.createQuery("FROM ProductPropertyEntity " +
                "where prodPropName=:name").setParameter("name", name).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (ProductPropertyEntity) list.get(0);
    }

    @Override
    public ProductPropertyEntity getProductPropertyById(int id) {

        List list = em.createQuery("FROM ProductPropertyEntity " +
                "where prodPropId=:id").setParameter("id", id).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (ProductPropertyEntity) list.get(0);
    }
}
