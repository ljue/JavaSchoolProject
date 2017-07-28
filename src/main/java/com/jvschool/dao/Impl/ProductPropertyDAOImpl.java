package com.jvschool.dao.Impl;

import com.jvschool.dao.ProductPropertyDAO;
import com.jvschool.entities.ProductPropertyEntity;
import org.hibernate.Session;
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

        ProductPropertyEntity property = (ProductPropertyEntity) em.createQuery("FROM ProductPropertyEntity " +
                "where prodPropName=:name").setParameter("name", name).getSingleResult();

        return property;
    }

    @Override
    public ProductPropertyEntity getProductPropertyById(int id) {

        ProductPropertyEntity property = (ProductPropertyEntity) em.createQuery("FROM ProductPropertyEntity " +
                "where prodPropId=:id").setParameter("id", id).getSingleResult();

        return property;
    }
}
