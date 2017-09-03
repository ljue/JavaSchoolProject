package com.jvschool.dao.Impl;

import com.jvschool.dao.api.BucketDAO;
import com.jvschool.dao.api.ProductDAO;
import com.jvschool.model.BucketEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BucketDAOImpl implements BucketDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<BucketEntity> getBucketsByProductId(long id) {

        List<BucketEntity> buckets = em.createQuery("from BucketEntity where productId=:id")
                .setParameter("id", productDAO.getProductById(id)).getResultList();

        return  buckets;
    }
}
