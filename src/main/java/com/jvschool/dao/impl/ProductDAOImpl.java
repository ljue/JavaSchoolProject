package com.jvschool.dao.impl;

import com.jvschool.dao.api.ProductDAO;
import com.jvschool.entities.ProductEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

/**
 * Created by Людмила on 23.07.2017.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void addProduct(ProductEntity productEntity) {

        em.merge(productEntity);

        em.flush();
        //em.refresh(productEntity);
//        List<PicturesEntity> lpic = productEntity.getPicturesByProductId();
//        for (PicturesEntity pic:lpic) {
//            pic.setProductByProductId(productEntity);
//            session.save(pic);
//        }

        //session.persist(productEntity);

    }

    @Override
    public ProductEntity getProductById(long id) {

        List list = em.createQuery("from ProductEntity where id=:id")
                .setParameter("id",id).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (ProductEntity) list.get(0);
    }

    @Override
    public List<ProductEntity> getAllProducts() {

        List<ProductEntity> products = em.createQuery("FROM ProductEntity ").getResultList();

        return  products;
    }

    @Override
    public List<ProductEntity> getProductsToBuy(Set<Long> set) {

        List<ProductEntity> products = em.createQuery("from ProductEntity pe where pe.id in (:list) ")
        .setParameter("list",set).getResultList();

        return  products;
    }
}
