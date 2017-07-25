package com.jvschool.dao.Impl;

import com.jvschool.entities.ProductCategoryEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 23.07.2017.
 */
@Repository
public class ProductCategoryDAOImpl implements com.jvschool.dao.ProductCategoryDAO {

    @Override
    public List<ProductCategoryEntity> getAllProductCategories() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List <ProductCategoryEntity> categories = session.createQuery("FROM ProductCategoryEntity ").list();
        session.getTransaction().commit();
        return categories;
    }

    @Override
    public ProductCategoryEntity getProductCategoryById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProductCategoryEntity category = (ProductCategoryEntity) session.createQuery("FROM ProductCategoryEntity " +
                "where categoryId=:id").setParameter("id", id).uniqueResult();
        session.getTransaction().commit();
        return category;
    }

    @Override
    public ProductCategoryEntity getProductCategoryByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ProductCategoryEntity category = (ProductCategoryEntity) session.createQuery("FROM ProductCategoryEntity " +
                "where categoryName=:name").setParameter("name", name).uniqueResult();
        session.getTransaction().commit();
        return category;
    }

    @Override
    public void addProductCategory(String name) {
        ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
        productCategoryEntity.setCategoryName(name);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(productCategoryEntity);
        session.getTransaction().commit();
    }

    @Override
    public void editCategory(ProductCategoryEntity category) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        int id = category.getCategoryId();
        String name = category.getCategoryName();
        session.beginTransaction();


        Query query = session.createQuery("UPDATE ProductCategoryEntity set categoryName=:name where id=:id").setParameter("id",id).setParameter("name", name);

        query.executeUpdate();
        session.getTransaction().commit();
    }


}
