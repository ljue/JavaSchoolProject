package com.jvschool.dao.Impl;

import com.jvschool.dao.ProductPropertyDAO;
import com.jvschool.entities.ProductPropertyEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


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
