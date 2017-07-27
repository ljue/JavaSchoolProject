package com.jvschool.dao.Impl;

import com.jvschool.dao.ProductDAO;
import com.jvschool.entities.PicturesEntity;
import com.jvschool.entities.ProductEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

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
//        List<PicturesEntity> lpic = productEntity.getPicturesByProductId();
//        for (PicturesEntity pic:lpic) {
//            pic.setProductByProductId(productEntity);
//            session.save(pic);
//        }

        //session.persist(productEntity);
        session.getTransaction().commit();
    }

    @Override
    public ProductEntity getProductById(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProductEntity productEntity = (ProductEntity) session.createQuery("from ProductEntity where id=:id")
                .setParameter("id",id).uniqueResult();
        session.getTransaction().commit();
        return  productEntity;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProductEntity> products = session.createQuery("from ProductEntity ").list();
        session.getTransaction().commit();
        return  products;
    }

    @Override
    public List<ProductEntity> getProductsToBuy(Set<Long> set) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<ProductEntity> products = session.createQuery("from ProductEntity pe where pe.id in (:list) ")
        .setParameterList("list",set).list();
        session.getTransaction().commit();
        return  products;
    }
}
