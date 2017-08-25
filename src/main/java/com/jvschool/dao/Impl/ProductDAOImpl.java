package com.jvschool.dao.Impl;

import com.jvschool.dao.CategoryDAO;
import com.jvschool.dao.ProductDAO;
import com.jvschool.dao.PropertyDAO;
import com.jvschool.dao.PropertyGroupDAO;
import com.jvschool.entities.*;
import com.jvschool.util.Attributes.FilterAttribute;
import javafx.beans.property.Property;
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
    @Autowired
    private PropertyGroupDAO propertyGroupDAO;


    @Override
    public void addProduct(ProductEntity productEntity) {

        em.merge(productEntity);
        em.flush();

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
    public List<ProductEntity> getProductsByCategory(CategoryEntity category) {

        List<ProductEntity> products = em.createQuery("FROM ProductEntity " +
                " where category=:category").setParameter("category", category).getResultList();

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

        int countTop = 10;
        countTop = countTop < list.size() ? countTop : list.size();

        return list.subList(0,countTop-1);
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
        if (filterAttribute.getCategory().equals("All")) {
            criteriaQuery.where(criteriaBuilder.and(
                    propertiesNotSolo,
                    product.join("properties").in(propertySoloEntityList),
                    criteriaBuilder.between(product.get("cost"), filterAttribute.getCostFROM(), filterAttribute.getCostTO()),
                    criteriaBuilder.between(product.get("flyTime"), filterAttribute.getFlyTimeFROM(), filterAttribute.getFlyTimeTO()),
                    criteriaBuilder.between(product.get("distance"), filterAttribute.getDistanceFROM(), filterAttribute.getDistanceTO())));
        }
        else {
            criteriaQuery.where(criteriaBuilder.and(
                    propertiesNotSolo,
                    product.join("properties").in(propertySoloEntityList),
                criteriaBuilder.between(product.get("cost"), filterAttribute.getCostFROM(), filterAttribute.getCostTO()),
                criteriaBuilder.between(product.get("flyTime"), filterAttribute.getFlyTimeFROM(), filterAttribute.getFlyTimeTO()),
                criteriaBuilder.between(product.get("distance"), filterAttribute.getDistanceFROM(), filterAttribute.getDistanceTO()),
                criteriaBuilder.equal(product.get("category"), categoryDAO.getProductCategoryByName(filterAttribute.getCategory()))));

        }
        List<ProductEntity> list = em.createQuery(criteriaQuery).getResultList();

        return list;
    }
}
