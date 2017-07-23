package com.jvschool.dao.Impl;

import com.jvschool.dao.ProductDAO;
import com.jvschool.entities.ProductEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Людмила on 23.07.2017.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    @Override
    public void addProduct(ProductEntity productEntity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(productEntity);
        session.getTransaction().commit();
    }
}
