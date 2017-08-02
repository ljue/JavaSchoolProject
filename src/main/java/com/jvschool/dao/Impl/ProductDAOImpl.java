package com.jvschool.dao.Impl;

import com.jvschool.dao.ProductDAO;
import com.jvschool.entities.OrderEntity;
import com.jvschool.entities.ProductEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;


@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void addProduct(ProductEntity productEntity) {

        em.merge(productEntity);
       //em.flush();
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

    @Override
    public List<ProductEntity> getTopProducts() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root order = criteriaQuery.from(OrderEntity.class);
        Join b = order.join("buckets");
        criteriaQuery.multiselect(b.get("productId"));
        criteriaQuery.groupBy(b.get("productId"));
        criteriaQuery.orderBy(criteriaBuilder.desc
                (criteriaBuilder.sum
                                (b.get("countProduct"))));

        List<ProductEntity> list = em.createQuery(criteriaQuery).getResultList();

        return list;
    }
}
