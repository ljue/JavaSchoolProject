package com.jvschool.dao.Impl;

import com.jvschool.entities.ProductCategoryEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class ProductCategoryDAOImpl implements com.jvschool.dao.ProductCategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ProductCategoryEntity> getAllProductCategories() {

        List <ProductCategoryEntity> categories = em.createQuery("FROM ProductCategoryEntity ").getResultList();

        return categories;
    }

    @Override
    public ProductCategoryEntity getProductCategoryById(int id) {

        List list = em.createQuery("FROM ProductCategoryEntity " +
                "where categoryId=:id").setParameter("id", id).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (ProductCategoryEntity) list.get(0);
    }

    @Override
    public ProductCategoryEntity getProductCategoryByName(String name) {

        List list  =  em.createQuery("FROM ProductCategoryEntity " +
                "where categoryName=:name").setParameter("name", name).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (ProductCategoryEntity) list.get(0);
    }

    @Override
    public void addProductCategory(String name) {
        ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
        productCategoryEntity.setCategoryName(name);

        em.persist(productCategoryEntity);

    }

    @Override
    public void editCategory(ProductCategoryEntity category) {

//        int id = category.getCategoryId();
//        String name = category.getCategoryName();

//        Query query = session.createQuery("UPDATE ProductCategoryEntity set categoryName=:name where id=:id").setParameter("id",id).setParameter("name", name);

//        query.executeUpdate();
        em.merge(category);
    }


}
