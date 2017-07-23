package com.jvschool.dao.Impl;

import com.jvschool.dao.PropertyRadioCategoryDAO;
import com.jvschool.entities.PropertyCategoryEntity;
import com.jvschool.entities.PropertyRadioCategoryEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Repository
public class PropertyRadioCategoryDAOImpl implements PropertyRadioCategoryDAO {

    @Override
    public List<PropertyRadioCategoryEntity> getAllRadioCategories() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List <PropertyRadioCategoryEntity> properties = session.createQuery("FROM PropertyRadioCategoryEntity ").list();
        session.getTransaction().commit();
        return properties;
    }
}
