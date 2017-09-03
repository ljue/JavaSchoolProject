package com.jvschool.dao.impl;


import com.jvschool.dao.api.CategoryDAO;
import com.jvschool.model.CategoryEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CategoryEntity> getAllProductCategories() {

        return em.createQuery("FROM CategoryEntity where visible=:visible ")
                .setParameter("visible", true).getResultList();
    }

    @Override
    public CategoryEntity getProductCategoryById(int id) {
        List list = em.createQuery("FROM CategoryEntity " +
                "where categoryId=:id").setParameter("id", id).getResultList();

        return (list.isEmpty()) ? null : (CategoryEntity) list.get(0);
    }

    @Override
    public CategoryEntity getProductCategoryByName(String name) {

        List list = em.createQuery("FROM CategoryEntity " +
                "where categoryName=:name").setParameter("name", name).getResultList();

        return (list.isEmpty()) ? null : (CategoryEntity) list.get(0);
    }

    @Override
    public void addProductCategory(String name) {
        final CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(name);
        categoryEntity.setVisible(true);
        em.persist(categoryEntity);
    }

    @Override
    public void editCategory(CategoryEntity category) {
        em.merge(category);
    }

    @Override
    public void removeCategory(CategoryEntity category) {

        Query query = em.createQuery("UPDATE CategoryEntity set visible=:visible where categoryId=:categoryId")
                .setParameter("categoryId", category.getCategoryId()).setParameter("visible", false);

        query.executeUpdate();
    }

    @Override
    public List<CategoryEntity> getRemovedCategories() {

        return em.createQuery("FROM CategoryEntity where visible=:visible ")
                .setParameter("visible", false).getResultList();
    }

    @Override
    public void returnCategory(CategoryEntity category) {
        Query query = em.createQuery("UPDATE CategoryEntity set visible=:visible where categoryId=:categoryId")
                .setParameter("categoryId", category.getCategoryId()).setParameter("visible", true);

        query.executeUpdate();
    }


}
