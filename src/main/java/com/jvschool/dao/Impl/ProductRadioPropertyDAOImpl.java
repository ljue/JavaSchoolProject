package com.jvschool.dao.Impl;

import com.jvschool.dao.ProductRadioPropertyDAO;
import com.jvschool.entities.ProductRadioPropertyEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Repository
public class ProductRadioPropertyDAOImpl implements ProductRadioPropertyDAO {
    @Override
    public List<ProductRadioPropertyEntity> getAllRadioProperties() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List <ProductRadioPropertyEntity> properties = session.createQuery("FROM ProductRadioPropertyEntity ").list();
        session.getTransaction().commit();
        return properties;
    }

    @Override
    public ProductRadioPropertyEntity getProductRadioPropertyByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProductRadioPropertyEntity property = (ProductRadioPropertyEntity) session.createQuery("FROM ProductRadioPropertyEntity " +
                "where name=:name").setParameter("name", name).uniqueResult();
        session.getTransaction().commit();
        return property;
    }

    @Override
    public ProductRadioPropertyEntity getProductRadioPropertyById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProductRadioPropertyEntity property = (ProductRadioPropertyEntity) session.createQuery("FROM ProductRadioPropertyEntity " +
                "where id=:id").setParameter("id", id).uniqueResult();
        session.getTransaction().commit();
        return property;
    }
}
