package com.jvschool.dao.Impl;

import com.jvschool.dao.RegionDAO;

import com.jvschool.entities.RegionEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
@Repository
public class RegionDAOImpl implements RegionDAO {

    public List<RegionEntity> getAllRegions() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<RegionEntity> regions = session.createQuery("from RegionEntity ").list();
        session.getTransaction().commit();
        return regions;
    }
}
