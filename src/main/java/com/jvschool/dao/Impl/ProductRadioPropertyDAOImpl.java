package com.jvschool.dao.Impl;

import com.jvschool.dao.ProductRadioPropertyDAO;
import com.jvschool.entities.ProductRadioPropertyEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ProductRadioPropertyDAOImpl implements ProductRadioPropertyDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductRadioPropertyEntity> getAllRadioProperties() {

        List <ProductRadioPropertyEntity> properties = em.createQuery("FROM ProductRadioPropertyEntity ").getResultList();

        return properties;
    }

    @Override
    public ProductRadioPropertyEntity getProductRadioPropertyByName(String name) {

        ProductRadioPropertyEntity property = (ProductRadioPropertyEntity) em.createQuery("FROM ProductRadioPropertyEntity " +
                "where name=:name").setParameter("name", name).getSingleResult();

        return property;
    }

    @Override
    public ProductRadioPropertyEntity getProductRadioPropertyById(int id) {

        ProductRadioPropertyEntity property = (ProductRadioPropertyEntity) em.createQuery("FROM ProductRadioPropertyEntity " +
                "where id=:id").setParameter("id", id).getSingleResult();

        return property;
    }
}
