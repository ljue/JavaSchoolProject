package com.jvschool.dao.Impl;

import com.jvschool.dao.PropertyCategoryDAO;
import com.jvschool.entities.PropertyCategoryEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Repository
public class PropertyCategoryDAOImpl implements PropertyCategoryDAO {

    @Override
    public List<PropertyCategoryEntity> getAllProductCategories() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List <PropertyCategoryEntity> properties = session.createQuery("FROM PropertyCategoryEntity ").list();
        session.getTransaction().commit();
        return properties;
    }

    @Override
    public PropertyCategoryEntity getProductCategoryById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        PropertyCategoryEntity property = (PropertyCategoryEntity) session.createQuery("FROM PropertyCategoryEntity " +
                "where propCatId=:id").setParameter("id", id).uniqueResult();
        session.getTransaction().commit();
        return property;
    }
}
