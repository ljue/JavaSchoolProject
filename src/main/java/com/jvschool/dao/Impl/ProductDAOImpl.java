package com.jvschool.dao.Impl;

import com.jvschool.dao.ProductCategoryDAO;
import com.jvschool.dao.ProductDAO;
import com.jvschool.entities.OrderEntity;
import com.jvschool.entities.ProductCategoryEntity;
import com.jvschool.entities.ProductEntity;
import com.jvschool.util.Attributes.FilterAttribute;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductCategoryDAO productCategoryDAO;


    @Override
    public void addProduct(ProductEntity productEntity) {

        em.merge(productEntity);

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
    public List<ProductEntity> getProductsByCategory(ProductCategoryEntity category) {

        List<ProductEntity> products = em.createQuery("FROM ProductEntity " +
                " where productCategoryByCategory=:category").setParameter("category", category).getResultList();

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

    @Override
    public List<ProductEntity> getProductsWithFilter(FilterAttribute filterAttribute) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root product = criteriaQuery.from(ProductEntity.class);
        criteriaQuery.multiselect(product);
        if (filterAttribute.getCategory().equals("All")) {
            criteriaQuery.where(criteriaBuilder.and(
                    criteriaBuilder.between(product.get("cost"), filterAttribute.getCostFROM(), filterAttribute.getCostTO()),
                    criteriaBuilder.between(product.get("flyTime"), filterAttribute.getFlyTimeFROM(), filterAttribute.getFlyTimeTO()),
                    criteriaBuilder.between(product.get("distance"), filterAttribute.getDistanceFROM(), filterAttribute.getDistanceTO())));
        }
        else {
            criteriaQuery.where(criteriaBuilder.and(
                criteriaBuilder.between(product.get("cost"), filterAttribute.getCostFROM(), filterAttribute.getCostTO()),
                criteriaBuilder.between(product.get("flyTime"), filterAttribute.getFlyTimeFROM(), filterAttribute.getFlyTimeTO()),
                criteriaBuilder.between(product.get("distance"), filterAttribute.getDistanceFROM(), filterAttribute.getDistanceTO()),
                criteriaBuilder.equal(product.get("productCategoryByCategory"), productCategoryDAO.getProductCategoryByName(filterAttribute.getCategory()))));

        }
        List<ProductEntity> list = em.createQuery(criteriaQuery).getResultList();

        return list;
    }
}
