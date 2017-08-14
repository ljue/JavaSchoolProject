package com.jvschool.dao.Impl;


import com.jvschool.dao.CategoryDAO;
import com.jvschool.entities.CategoryEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CategoryEntity> getAllProductCategories() {

        List<CategoryEntity> categories = em.createQuery("FROM CategoryEntity ").getResultList();

        return categories;
    }

    @Override
    public CategoryEntity getProductCategoryById(int id) {
        //CategoryEntity category = em.find(CategoryEntity.class, id);
        List list = em.createQuery("FROM CategoryEntity " +
                "where categoryId=:id").setParameter("id", id).getResultList();

        if (list.isEmpty())
            return null;
        else
            return (CategoryEntity) list.get(0);
    }

    @Override
    public CategoryEntity getProductCategoryByName(String name) {

        List list = em.createQuery("FROM CategoryEntity " +
                "where categoryName=:name").setParameter("name", name).getResultList();

        if (list.isEmpty())
            return null;
        else
            return (CategoryEntity) list.get(0);
    }

    @Override
    public void addProductCategory(String name) {
        final CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(name);

        em.persist(categoryEntity);

    }

    @Override
    public void editCategory(CategoryEntity category) {

        em.merge(category);
    }


}
