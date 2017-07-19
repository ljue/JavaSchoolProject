package com.jvschool.dao.Impl;



import com.jvschool.dao.CountryDAO;
import com.jvschool.entities.CountryEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Людмила on 14.07.2017.
 */

@Repository
public class CountryDAOImpl implements CountryDAO {


    public CountryEntity getCountryById(Long id){
        CountryEntity country = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        country = session.load(CountryEntity.class, id);
        session.getTransaction().commit();

        return country;

    }


    public List<CountryEntity> getAllCountries() {

        List countries;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        countries = session.createQuery("from CountryEntity ").list();
        session.getTransaction().commit();
        return countries;
    }
//    public List<CountryEntity> getAllCountries() {
//
//        Session session = null;
//        List countries = new ArrayList<CountryEntity>();
//
//
//        try {
//            session = HibernateUtil.getSessionFactory().openSession();
//            countries = session.createCriteria(CountryEntity.class).list();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
//        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//            }
//        }
//        return countries;
//    }
}
