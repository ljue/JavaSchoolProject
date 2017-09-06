package com.jvschool.dao.impl;

import com.jvschool.dao.api.CategoryDAO;
import com.jvschool.dao.api.ProductDAO;
import com.jvschool.dao.api.PropertyDAO;
import com.jvschool.model.*;
import com.jvschool.dto.FilterAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private PropertyDAO propertyDAO;


    @Override
    public void addProduct(ProductEntity productEntity) {

        productEntity.setVisible(true);
        em.merge(productEntity);
        em.flush();

    }

    @Override
    public ProductEntity getProductById(long id) {

        List list = em.createQuery("from ProductEntity where id=:id")
                .setParameter("id", id).getResultList();

        return (list.isEmpty()) ? null : (ProductEntity) list.get(0);
    }

    @Override
    public List<ProductEntity> getAllProducts() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root order = criteriaQuery.from(OrderEntity.class);
        Join b = order.join("buckets");
        criteriaQuery.multiselect(b.get("productId"));
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(b.get("productId").get("visible"), true),
                criteriaBuilder.equal(b.get("productId").get("category").get("visible"), true)));
        criteriaQuery.groupBy(b.get("productId"));
        criteriaQuery.orderBy(criteriaBuilder.desc
                (criteriaBuilder.sum
                        (b.get("countProduct"))));

        List<ProductEntity> topProducts = em.createQuery(criteriaQuery).getResultList();

        List<ProductEntity> allProducts = em.createQuery("FROM ProductEntity " +
                "where visible=:visible and category.visible=:visibleCategory order by productId desc")
                .setParameter("visible", true).setParameter("visibleCategory", true).getResultList();
        for (ProductEntity productEntity : topProducts) {
            allProducts.remove(productEntity);
        }
        topProducts.addAll(allProducts);

        return topProducts;
    }

    @Override
    public List<ProductEntity> getProductsByCategory(CategoryEntity category) {

        return  em.createQuery("FROM ProductEntity " +
                " where category=:category and visible=:visible ").setParameter("category", category)
                .setParameter("visible", true).getResultList();
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

        int countTop = 10;
        countTop = countTop < list.size() ? countTop : list.size();

        return list.subList(0, countTop);
    }

    @Override
    public List<ProductEntity> getProductsWithFilter(FilterAttribute filterAttribute) {

        List<PropertyEntity> propertySoloEntityList = new ArrayList<>();
        List<PropertyEntity> propertyNotSoloEntityList = new ArrayList<>();

        for (String property : filterAttribute.getProperties()) {
            PropertyEntity propertyEntity = propertyDAO.getPropertyByName(property);
            if (propertyEntity.getPropertyGroup().isSolo()) {
                propertySoloEntityList.add(propertyEntity);
            } else {
                propertyNotSoloEntityList.add(propertyEntity);
            }
        }

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root product = criteriaQuery.from(ProductEntity.class);

        Predicate propertiesNotSolo = criteriaBuilder.conjunction();
        for (PropertyEntity propertyEntity : propertyNotSoloEntityList) {
            propertiesNotSolo = criteriaBuilder.and(propertiesNotSolo, criteriaBuilder.
                    equal(product.join("properties"), propertyEntity));
        }

        criteriaQuery.multiselect(product).distinct(true);

        if(propertySoloEntityList.isEmpty()) {
            if (filterAttribute.getCategory() == null) {
                criteriaQuery.where(criteriaBuilder.and(
                        propertiesNotSolo,
                        criteriaBuilder.equal(product.get("visible"), true),
                        criteriaBuilder.equal(product.get("category").get("visible"), true),
                        criteriaBuilder.between(product.get("cost"), filterAttribute.getCostFROM(), filterAttribute.getCostTO()),
                        criteriaBuilder.between(product.get("flyTime"), filterAttribute.getFlyTimeFROM(), filterAttribute.getFlyTimeTO()),
                        criteriaBuilder.between(product.get("distance"), filterAttribute.getDistanceFROM(), filterAttribute.getDistanceTO())));
            } else {
                criteriaQuery.where(criteriaBuilder.and(
                        propertiesNotSolo,
                        criteriaBuilder.equal(product.get("visible"), true),
                        criteriaBuilder.equal(product.get("category").get("visible"), true),
                        criteriaBuilder.between(product.get("cost"), filterAttribute.getCostFROM(), filterAttribute.getCostTO()),
                        criteriaBuilder.between(product.get("flyTime"), filterAttribute.getFlyTimeFROM(), filterAttribute.getFlyTimeTO()),
                        criteriaBuilder.between(product.get("distance"), filterAttribute.getDistanceFROM(), filterAttribute.getDistanceTO()),
                        criteriaBuilder.equal(product.get("category"), categoryDAO.getProductCategoryByName(filterAttribute.getCategory()))));

            }
        } else {
            if (filterAttribute.getCategory() == null) {
                criteriaQuery.where(criteriaBuilder.and(
                        propertiesNotSolo,
                        product.join("properties").in(propertySoloEntityList),
                        criteriaBuilder.equal(product.get("visible"), true),
                        criteriaBuilder.equal(product.get("category").get("visible"), true),
                        criteriaBuilder.between(product.get("cost"), filterAttribute.getCostFROM(), filterAttribute.getCostTO()),
                        criteriaBuilder.between(product.get("flyTime"), filterAttribute.getFlyTimeFROM(), filterAttribute.getFlyTimeTO()),
                        criteriaBuilder.between(product.get("distance"), filterAttribute.getDistanceFROM(), filterAttribute.getDistanceTO())));
            } else {
                criteriaQuery.where(criteriaBuilder.and(
                        propertiesNotSolo,
                        product.join("properties").in(propertySoloEntityList),
                        criteriaBuilder.equal(product.get("visible"), true),
                        criteriaBuilder.equal(product.get("category").get("visible"), true),
                        criteriaBuilder.between(product.get("cost"), filterAttribute.getCostFROM(), filterAttribute.getCostTO()),
                        criteriaBuilder.between(product.get("flyTime"), filterAttribute.getFlyTimeFROM(), filterAttribute.getFlyTimeTO()),
                        criteriaBuilder.between(product.get("distance"), filterAttribute.getDistanceFROM(), filterAttribute.getDistanceTO()),
                        criteriaBuilder.equal(product.get("category"), categoryDAO.getProductCategoryByName(filterAttribute.getCategory()))));

            }
        }

        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public long getCountProducts() {

        return (long) em.createQuery("select count(p.productId) from ProductEntity p where p.visible=:visible " +
                " and p.category.visible=:visibleCategory ")
                .setParameter("visible", true).setParameter("visibleCategory", true).getSingleResult();
    }

    @Override
    public List<ProductEntity> getProductsFromTo(int page, int count) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root order = criteriaQuery.from(OrderEntity.class);
        Join b = order.join("buckets");
        criteriaQuery.multiselect(b.get("productId"));
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(b.get("productId").get("visible"), true),
                criteriaBuilder.equal(b.get("productId").get("category").get("visible"), true)));
        criteriaQuery.groupBy(b.get("productId"));
        criteriaQuery.orderBy(criteriaBuilder.desc
                (criteriaBuilder.sum
                        (b.get("countProduct"))));

        List<ProductEntity> topProducts = em.createQuery(criteriaQuery).getResultList();

        List<ProductEntity> allProducts = em.createQuery("FROM ProductEntity where visible=:visible " +
                " and category.visible=:visibleCategory order by productId desc")
                .setParameter("visible", true).setParameter("visibleCategory", true).getResultList();
        for (ProductEntity productEntity : topProducts) {
            allProducts.remove(productEntity);
        }
        topProducts.addAll(allProducts);

        int from = (page - 1) * count;
        int to = page * count;
        if ( to > topProducts.size()) {
            to = topProducts.size();
        }
        return topProducts.subList(from, to);
    }
}