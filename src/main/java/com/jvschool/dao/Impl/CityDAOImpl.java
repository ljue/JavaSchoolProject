package com.jvschool.dao.Impl;

import com.jvschool.dao.CityDAO;
import com.jvschool.entities.CityEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
@Repository
public class CityDAOImpl implements CityDAO {

    @Override
    public List<CityEntity> getAllCities() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<CityEntity> cities = session.createQuery("from CityEntity ").list();
        session.getTransaction().commit();
        return cities;
    }
}
