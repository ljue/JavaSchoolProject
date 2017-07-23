package com.jvschool.dao.Impl;

import com.jvschool.dao.ProductPropertyDAO;
import com.jvschool.entities.ProductPropertyEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Repository
public class ProductPropertyDAOImpl implements ProductPropertyDAO {
    @Override
    public List<ProductPropertyEntity> getAllProductProperties() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List <ProductPropertyEntity> properties = session.createQuery("FROM ProductPropertyEntity ").list();
        session.getTransaction().commit();
        return properties;
    }

    @Override
    public ProductPropertyEntity getProductPropertyByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProductPropertyEntity property = (ProductPropertyEntity) session.createQuery("FROM ProductPropertyEntity " +
                "where prodPropName=:name").setParameter("name", name).uniqueResult();
        session.getTransaction().commit();
        return property;
    }

    @Override
    public ProductPropertyEntity getProductPropertyById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProductPropertyEntity property = (ProductPropertyEntity) session.createQuery("FROM ProductPropertyEntity " +
                "where prodPropId=:id").setParameter("id", id).uniqueResult();
        session.getTransaction().commit();
        return property;
    }
}
